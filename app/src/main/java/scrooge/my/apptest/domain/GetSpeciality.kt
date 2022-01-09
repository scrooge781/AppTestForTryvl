package scrooge.my.apptest.domain

import scrooge.my.apptest.data.local.speciality.SpecialityService
import scrooge.my.apptest.data.model.Specialty

class GetSpeciality(
    val specialityService: SpecialityService
) {

    fun getSpeciality(): List<Specialty>{
        return specialityService.getSpecialist()
    }
}