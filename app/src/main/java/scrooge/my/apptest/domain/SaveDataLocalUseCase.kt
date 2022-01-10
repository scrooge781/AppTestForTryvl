package scrooge.my.apptest.domain

import scrooge.my.apptest.data.local.specialist.SpecialistService
import scrooge.my.apptest.data.local.speciality.SpecialityService
import scrooge.my.apptest.data.model.Specialist
import scrooge.my.apptest.data.model.Specialty
import scrooge.my.apptest.util.UtilFunction.capitalizeName
import scrooge.my.apptest.util.UtilFunction.getAge
import scrooge.my.apptest.util.UtilFunction.parsingDate

class SaveDataLocalUseCase(
    private val getDataRemoteUsesCase: GetDataRemoteUsesCase,
    private val specialistService: SpecialistService,
    private val specialityService: SpecialityService
) {

    suspend fun saveDataLocal() {
        val listSpecialist = getDataRemoteUsesCase.getDataRemote()!!

        for (i in listSpecialist) {
            var birthday = if(i.birthday != null) i.birthday else ""
            birthday = parsingDate(birthday)
            val age = getAge(birthday)

            val specialist = Specialist(
                avatr_url = i.avatr_url,
                birthday = birthday,
                age = age,
                f_name = capitalizeName(i.f_name),
                l_name = capitalizeName(i.l_name),
                speciality_id = i.specialty[0].specialty_id
            )
            specialistService.saveSpecialistItem(specialist)

            val speciality = Specialty(i.specialty[0].specialty_id, i.specialty[0].name)
            specialityService.saveSpecialityItem(speciality)

        }

    }
}
