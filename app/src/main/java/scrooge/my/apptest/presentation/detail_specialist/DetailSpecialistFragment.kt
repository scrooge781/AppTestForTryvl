package scrooge.my.apptest.presentation.detail_specialist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import scrooge.my.apptest.R
import scrooge.my.apptest.databinding.FragmentDetailSpecialistBinding

@AndroidEntryPoint
class DetailSpecialistFragment : Fragment() {

    private val args by navArgs<DetailSpecialistFragmentArgs>()
    private var _binding: FragmentDetailSpecialistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailSpecialistBinding.inflate(inflater, container, false)

        println(args.getSpecialist.toString())



        Glide.with(this)
            .load(args.getSpecialist.avatr_url)
            .error(R.drawable.default_image_specialist)
            .into(binding.ivDetailSpecialist)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}