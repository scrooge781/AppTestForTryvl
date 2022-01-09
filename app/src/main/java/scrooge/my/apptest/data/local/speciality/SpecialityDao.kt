package scrooge.my.apptest.data.local.speciality

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import scrooge.my.apptest.data.model.Specialty

@Dao
interface SpecialityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSpecialityItem(specialty: Specialty)

    @Query("SELECT * FROM specialty")
    fun getSpecialist(): List<Specialty>

    @Query("SELECT * FROM specialty WHERE specialty_id =:idSpeciality")
    fun getSpecialtyId(idSpeciality: Int): Specialty
}