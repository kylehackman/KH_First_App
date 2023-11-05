package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.khfirstapp.databinding.FragmentPlayGameBinding
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

    private fun observeAsset() {
        PlayGameViewModel.assetState.observe(this) {
            binding.playGameName.text = it.name
            binding.playGameImage.tag = it.imageFileName
        }
    }

    private fun observeScore() {
        PlayGameViewModel.scoreState.observe(this) {
            binding.playGameScore.text = it.toString()
        }
    }

    private fun observeGuessingPrice() {
        PlayGameViewModel.guessingPriceState.observe(this) {
            val formattedPrice = "$" + DecimalFormat("#,###").format(it)
            binding.playGameGuessingPrice.text = formattedPrice
        }
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
        super.onDestroyView()
    }
}
