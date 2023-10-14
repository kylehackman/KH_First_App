package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackman.kyle.khfirstapp.databinding.FragmentStartBinding
import hackman.kyle.logic.StartViewModel

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindStartButton()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun bindStartButton() {
        binding.start.setOnClickListener {
            StartViewModel.clickStart()
        }
    }
}
