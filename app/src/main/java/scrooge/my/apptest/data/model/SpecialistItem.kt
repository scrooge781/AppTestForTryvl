package scrooge.my.apptest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SpecialistItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val avatr_url: String,
    val birthday: String,
    val f_name: String,
    val l_name: String,
    val specialty: List<Specialty>
) {
    constructor(
        avatr_url: String,
        birthday: String,
        f_name: String,
        l_name: String,
        specialty: List<Specialty>
    ) : this(0, avatr_url, birthday, f_name, l_name, specialty)
}