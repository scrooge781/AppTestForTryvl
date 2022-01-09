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
    val f_name: String,
    val l_name: String,

    ) : Parcelable {
    constructor(
        avatr_url: String,
        birthday: String,
        f_name: String,
        l_name: String
    ) : this(0, avatr_url, birthday, f_name, l_name)
}