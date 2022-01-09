package scrooge.my.apptest.presentation.speciality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import scrooge.my.apptest.databinding.FragmentSpecialityListBinding
import scrooge.my.apptest.presentation.MainViewModel
import scrooge.my.apptest.presentation.speciality.adapter.SpecialityListAdapter

@AndroidEntryPoint
class SpecialityListFragment : Fragment() {

    private var _binding: FragmentSpecialityListBinding? = null
    private val binding get() = _binding!!
    private lateinit var specialityListAdapter: SpecialityListAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.saveData()

        viewModel.shouldCloseScreen.observe(viewLifecycleOwner){
            println("this op saved data")
        }
    }

    private fun setupRecyclerView() {
        val rvSpecialityList = binding.rvSpeciality

        with(rvSpecialityList) {
            specialityListAdapter = SpecialityListAdapter()
            adapter = specialityListAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}