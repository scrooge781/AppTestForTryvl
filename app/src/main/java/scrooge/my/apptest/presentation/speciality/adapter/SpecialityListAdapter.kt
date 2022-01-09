package scrooge.my.apptest.presentation.speciality.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import scrooge.my.apptest.R
import scrooge.my.apptest.data.model.Specialty
import scrooge.my.apptest.presentation.speciality.SpecialityListFragmentDirections

class SpecialityListAdapter :
    ListAdapter<Specialty, SpecialityListViewHolder>(SpecialityListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_speciality_list, parent, false)
        return SpecialityListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialityListViewHolder, position: Int) {
        val specialityItem = getItem(position)
        holder.speciality.text = specialityItem.name
        holder.viewSpeciality.setOnClickListener {
            val action =
                SpecialityListFragmentDirections.actionSpecialityListFragmentToSpecialistListFragment(
                    specialityItem
                )
            it.findNavController().navigate(action)
        }
    }


}