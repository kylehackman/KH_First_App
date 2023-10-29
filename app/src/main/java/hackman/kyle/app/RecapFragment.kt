package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.khfirstapp.databinding.FragmentRecapBinding
import hackman.kyle.logic.RecapViewModel

class RecapFragment : Fragment() {

    private var _binding: FragmentRecapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindBackButton()
        observeScore()
    }

    private fun observeScore() {
        RecapViewModel.recapScoreState.addObserver {
            binding.scoreValue.text = it.toString()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun bindBackButton() {
        binding.back.setOnClickListener {
            RecapViewModel.clickBack()
        }
    }
}
