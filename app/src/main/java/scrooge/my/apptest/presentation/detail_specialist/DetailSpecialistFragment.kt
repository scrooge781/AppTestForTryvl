package scrooge.my.apptest.presentation.detail_specialist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import scrooge.my.apptest.R
import scrooge.my.apptest.databinding.FragmentDetailSpecialistBinding
import scrooge.my.apptest.presentation.MainViewModel

@AndroidEntryPoint
class DetailSpecialistFragment : Fragment() {

    private val args by navArgs<DetailSpecialistFragmentArgs>()
    private var _binding: FragmentDetailSpecialistBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailSpecialistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSpecialityId(args.getSpecialist.speciality_id)
        setupInfoSpecialist()
        setupObserverViewModel()
    }

    private fun setupInfoSpecialist() {
        Glide.with(this)
            .load(args.getSpecialist.avatr_url)
            .error(R.drawable.default_image_specialist)
            .into(binding.ivDetailSpecialist)
        binding.tvFirstLastNameDetailSpecialist.text =
            "${args.getSpecialist.f_name} ${args.getSpecialist.l_name} "
        binding.tvBirthdayDetailSpecialist.text = args.getSpecialist.birthday
        binding.tvAgeDetailSpecialist.text = args.getSpecialist.age
    }

    private fun setupObserverViewModel() {
        viewModel.speciality.observe(viewLifecycleOwner) {
            binding.tvSpecialityDetailSpecialist.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}