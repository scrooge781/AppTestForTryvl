package scrooge.my.apptest.presentation.specialist.adapter

import androidx.recyclerview.widget.DiffUtil
import scrooge.my.apptest.data.model.Specialist

class SpecialistListDiffCallback : DiffUtil.ItemCallback<Specialist>() {
    override fun areItemsTheSame(old: Specialist, aNew: Specialist): Boolean {
        return old.id == aNew.id
    }

    override fun areContentsTheSame(old: Specialist, aNew: Specialist): Boolean {
        return old == aNew
    }
}