package scrooge.my.apptest.presentation.specialist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import scrooge.my.apptest.R
import scrooge.my.apptest.databinding.FragmentSpecialistListBinding

class SpecialistListFragment : Fragment() {

    private var _binding: FragmentSpecialistListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialistListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}