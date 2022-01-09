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
    @PrimaryKey(autoGenerate = false)
    val specialty_id: Int,
    val name: String
) : Parcelable