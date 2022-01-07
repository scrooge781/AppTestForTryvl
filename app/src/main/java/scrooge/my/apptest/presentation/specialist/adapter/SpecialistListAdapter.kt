package scrooge.my.apptest.presentation.specialist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import scrooge.my.apptest.R
import scrooge.my.apptest.data.model.Specialist

class SpecialistListAdapter(private val context: Context) :
    ListAdapter<Specialist, SpecialistListViewHolder>(SpecialistListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialistListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_specialist_list, parent, false)
        return SpecialistListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialistListViewHolder, position: Int) {
        val specialistItem = getItem(position)

        holder.nameSpecialist.text = "${specialistItem.f_name} ${specialistItem.l_name}"
        holder.birthdaySpecialist.text = specialistItem.birthday
        Glide.with(context)
            .load(specialistItem.avatr_url)
            .error(R.drawable.default_image_specialist)
            .into(holder.imageSpecialist)
        holder.viewSpecialist.setOnClickListener {
            print("tap")
        }

    }
}