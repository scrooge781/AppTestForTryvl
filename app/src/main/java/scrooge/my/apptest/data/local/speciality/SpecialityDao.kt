package scrooge.my.apptest.data.local.speciality

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import scrooge.my.apptest.data.model.Specialty

@Dao
interface SpecialityDao {

    @Insert
    suspend fun saveSpecialityItem(specialty: Specialty)

    @Query("SELECT * FROM specialty")
    fun getSpecialistItem(): List<Specialty>

    @Query("SELECT * FROM specialty WHERE specialty_id =:idSpeciality")
    fun getSpecialtyId(idSpeciality: Int): Specialty
}