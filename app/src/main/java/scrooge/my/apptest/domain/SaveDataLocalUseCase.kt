package scrooge.my.apptest.domain

import scrooge.my.apptest.data.local.specialist.SpecialistService
import scrooge.my.apptest.data.local.speciality.SpecialityService
import scrooge.my.apptest.data.model.Specialist
import scrooge.my.apptest.data.model.Specialty
import scrooge.my.apptest.util.UtilFunction.capitalizeName
import scrooge.my.apptest.util.UtilFunction.parsingDate

class SaveDataLocalUseCase(
    private val getDataRemoteUsesCase: GetDataRemoteUsesCase,
    private val specialistService: SpecialistService,
    private val specialityService: SpecialityService
) {

    suspend fun saveDataLocal() {
        val listSpecialist = getDataRemoteUsesCase.getDataRemote()!!

        for (i in listSpecialist) {
            val specialist = Specialist(
                avatr_url = i.avatr_url,
                birthday = parsingDate(i.birthday),
                f_name = capitalizeName(i.f_name),
                l_name = capitalizeName(i.l_name),
                speciality_id = i.specialty[0].specialty_id
            )
            specialistService.saveSpecialistItem(specialist)

            if (specialityService.getSpecialtyId(i.specialty[0].specialty_id) == null) {
                val speciality = Specialty(i.specialty[0].specialty_id, i.specialty[0].name)
                specialityService.saveSpecialityItem(speciality)
            }

        }

    }
}
