package scrooge.my.apptest.presentation.speciality.adapter

import androidx.recyclerview.widget.DiffUtil
import scrooge.my.apptest.data.model.Specialty

class SpecialityListDiffCallback : DiffUtil.ItemCallback<Specialty>() {
    override fun areItemsTheSame(oldItem: Specialty, newItem: Specialty): Boolean {
        return oldItem.specialty_id == newItem.specialty_id
    }

    override fun areContentsTheSame(oldItem: Specialty, newItem: Specialty): Boolean {
        return oldItem == newItem
    }
}