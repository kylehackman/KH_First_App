package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import hackman.kyle.khfirstapp.R
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
        PlayGameViewModel.assetState.addObserver {
            val formattedPrice = "$" + DecimalFormat("#,###").format(it.actualPrice)
            binding.playGameValue.text = formattedPrice
            binding.playGameName.text = it.name
            binding.playGameImage.tag = it.imageURL
        }
    }

    private fun observeScore() {
        PlayGameViewModel.scoreState.addObserver {
            binding.playGameScore.text = it.toString()
        }
    }

    private fun observeGuessingPrice() {
        PlayGameViewModel.guessingPriceState.addObserver {
            binding.playGameScore.text = it.toString()
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
        PlayGameViewModel.assetState.removeAllObservers()
        super.onDestroyView()
    }

    private fun navigateToRecap() {
        parentFragmentManager.commit {
            add(R.id.fragment_play_game, RecapFragment())
            addToBackStack("play")
        }
    }
}
