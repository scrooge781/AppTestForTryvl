package scrooge.my.apptest.data.model

data class SpecialistItem(
    val id: Long = 0,
    val avatr_url: String,
    val birthday: String,
    val f_name: String,
    val l_name: String,
    val specialty: List<Specialty>
)