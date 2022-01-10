package scrooge.my.apptest.domain

import scrooge.my.apptest.data.local.speciality.SpecialityService
import scrooge.my.apptest.data.model.Specialty

class GetSpecialityUseCase(
    val specialityService: SpecialityService
) {

    fun getSpeciality(): List<Specialty>{
        return specialityService.getSpecialist()
    }

    fun getSpecialityId(specialty_id: Int): Specialty{
        return specialityService.getSpecialtyId(specialty_id)
    }
}