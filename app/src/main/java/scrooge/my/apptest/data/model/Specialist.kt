package scrooge.my.apptest.data.model

import android.os.Parcelable
import androidx.core.os.trace
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Specialist(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val avatr_url: String,
    val birthday: String,
    val age: String,
    val f_name: String,
    val l_name: String,
    val speciality_id: Int

) : Parcelable {
    constructor(
        avatr_url: String,
        birthday: String,
        age: String,
        f_name: String,
        l_name: String,
        speciality_id: Int
    ) : this(0, avatr_url, birthday, age, f_name, l_name, speciality_id)
}