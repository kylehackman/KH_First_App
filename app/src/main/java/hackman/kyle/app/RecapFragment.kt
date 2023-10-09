package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import hackman.kyle.khfirstapp.databinding.FragmentRecapBinding

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
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun bindBackButton() {
        binding.back.setOnClickListener {
            navigateToStart()
        }
    }

    private fun navigateToStart() {
        parentFragmentManager.popBackStack("start", POP_BACK_STACK_INCLUSIVE)
    }
}
