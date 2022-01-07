package scrooge.my.apptest.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Specialty(
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,

    @SerializedName("specialty_id")
    @ColumnInfo(name = "specialty_id")
    @PrimaryKey(autoGenerate = false)
    val specialty_id: Int

) : Parcelable