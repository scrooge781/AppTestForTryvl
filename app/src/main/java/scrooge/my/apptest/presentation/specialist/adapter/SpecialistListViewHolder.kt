package scrooge.my.apptest.presentation.specialist.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import scrooge.my.apptest.R

class SpecialistListViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    val imageSpecialist = view.findViewById<ImageView>(R.id.ivItemSpecialist)
    val nameSpecialist = view.findViewById<TextView>(R.id.tvItemSpecialistName)
    val birthdaySpecialist = view.findViewById<TextView>(R.id.tvItemSpecialistBirthday)
    val viewSpecialist = view.findViewById<ConstraintLayout>(R.id.clItemSpecialist)

}