package scrooge.my.apptest.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Specialist(
    @SerializedName("avatr_url")
    @ColumnInfo(name = "avatr_url")
    val avatr_url: String,

    @SerializedName("birthday")
    @ColumnInfo(name = "birthday")
    val birthday: String,

    @SerializedName("f_name")
    @ColumnInfo(name = "f_name")
    val f_name: String,

    @SerializedName("l_name")
    @ColumnInfo(name = "l_name")
    val l_name: String,

    @Embedded
    val specialty: List<Specialty>
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0

}