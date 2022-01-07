package scrooge.my.apptest.presentation.speciality.adapter

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import scrooge.my.apptest.R

class SpecialityListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    val speciality = view.findViewById<TextView>(R.id.tvItemSpeciality)
    val viewSpeciality = view.findViewById<ConstraintLayout>(R.id.clItemSpeciality)
}