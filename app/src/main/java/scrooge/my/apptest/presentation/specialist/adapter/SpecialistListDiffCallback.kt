package scrooge.my.apptest.presentation.specialist.adapter

import androidx.recyclerview.widget.DiffUtil
import scrooge.my.apptest.data.model.SpecialistItem

class SpecialistListDiffCallback : DiffUtil.ItemCallback<SpecialistItem>() {
    override fun areItemsTheSame(oldItem: SpecialistItem, newItem: SpecialistItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SpecialistItem, newItem: SpecialistItem): Boolean {
        return oldItem == newItem
    }
}