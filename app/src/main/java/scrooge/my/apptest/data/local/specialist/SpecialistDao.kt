package scrooge.my.apptest.data.local.specialist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import scrooge.my.apptest.data.model.Specialist

@Dao
interface SpecialistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSpecialistItem(specialist: Specialist)

    @Query("SELECT * FROM specialist WHERE speciality_id =:specialist_id")
    fun getSpecialist(specialist_id: Int): List<Specialist>
}