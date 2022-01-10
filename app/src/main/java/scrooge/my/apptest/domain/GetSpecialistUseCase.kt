package scrooge.my.apptest.domain

import scrooge.my.apptest.data.local.specialist.SpecialistService
import scrooge.my.apptest.data.model.Specialist

class GetSpecialistUseCase(
    private val specialistService: SpecialistService
) {

    fun getSpecialist(specialist_id: Int): List<Specialist>{
        return specialistService.getSpecialist(specialist_id)
    }
}