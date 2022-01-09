package scrooge.my.apptest.data.local.specialist

import scrooge.my.apptest.data.model.Specialist
import javax.inject.Inject

class SpecialistService @Inject constructor(
    private val specialistDao: SpecialistDao
) : SpecialistDao {
    override suspend fun saveSpecialistItem(specialist: Specialist) {
        specialistDao.saveSpecialistItem(specialist)
    }

    override fun getSpecialist(specialist_id: Int): List<Specialist> {
        return specialistDao.getSpecialist(specialist_id)
    }


}