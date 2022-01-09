package scrooge.my.apptest.data.local.speciality

import scrooge.my.apptest.data.model.Specialty
import javax.inject.Inject

class SpecialityService @Inject constructor(
    private val specialityDao: SpecialityDao
) : SpecialityDao {
    override suspend fun saveSpecialityItem(specialty: Specialty) {
        specialityDao.saveSpecialityItem(specialty)
    }

    override fun getSpecialist(): List<Specialty> {
        return specialityDao.getSpecialist()
    }

    override fun getSpecialtyId(idSpeciality: Int): Specialty {
        return specialityDao.getSpecialtyId(idSpeciality)
    }
}