package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.khfirstapp.databinding.FragmentPlayGameBinding
import hackman.kyle.logic.Asset
import hackman.kyle.logic.PlayGameViewModel
import java.text.DecimalFormat

class PlayGameFragment : Fragment() {

    private var _binding: FragmentPlayGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindLowerButton()
        bindHigherButton()
        observeAsset()
        observeScore()
        observeGuessingPrice()
    }

    private val observerAsset: (Asset) -> Unit = {
        binding.playGameName.text = it.name
        binding.playGameImage.tag = it.imageURL
    }

    private fun observeAsset() {
        PlayGameViewModel.assetState.addObserver(observerAsset)
    }

    private val observerScore: (Int) -> Unit = {
        binding.playGameScore.text = it.toString()
    }

    private fun observeScore() {
        PlayGameViewModel.scoreState.addObserver(observerScore)
    }

    private val observerGuessingPrice: (Int) -> Unit ={
        val formattedPrice = "$" + DecimalFormat("#,###").format(it)
        binding.playGameGuessingPrice.text = formattedPrice
    }

    private fun observeGuessingPrice() {
        PlayGameViewModel.guessingPriceState.addObserver(observerGuessingPrice)
    }

    private fun bindLowerButton() {
        binding.playGameLowerButton.setOnClickListener {
            PlayGameViewModel.clickLower()
        }
    }

    private fun bindHigherButton() {
        binding.playGameHigherButton.setOnClickListener {
            PlayGameViewModel.clickHigher()
        }
    }

    override fun onDestroyView() {
        _binding = null
        PlayGameViewModel.assetState.removeObserver(observerAsset)
        PlayGameViewModel.scoreState.removeObserver(observerScore)
        PlayGameViewModel.guessingPriceState.removeObserver(observerGuessingPrice)
        super.onDestroyView()
    }
}
