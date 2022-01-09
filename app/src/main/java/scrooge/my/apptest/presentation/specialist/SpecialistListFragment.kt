package scrooge.my.apptest.presentation.specialist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import scrooge.my.apptest.databinding.FragmentSpecialistListBinding
import scrooge.my.apptest.presentation.specialist.adapter.SpecialistListAdapter

@AndroidEntryPoint
class SpecialistListFragment : Fragment() {

    private val args by navArgs<SpecialistListFragmentArgs>()
    private var _binding: FragmentSpecialistListBinding? = null
    private val binding get() = _binding!!
    private lateinit var specialistListAdapter: SpecialistListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialistListBinding.inflate(inflater, container, false)

        println(args.getSpecialty.toString())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvSpecialistList = binding.rvSpecialist
        with(rvSpecialistList) {
            specialistListAdapter = SpecialistListAdapter(requireContext())
            adapter = specialistListAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}