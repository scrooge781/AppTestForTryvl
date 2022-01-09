package scrooge.my.apptest.data.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("response")
    val response: List<SpecialistResponse>
)

data class SpecialistResponse(
    @SerializedName("avatr_url")
    val avatr_url: String,

    @SerializedName("birthday")
    val birthday: String,

    @SerializedName("f_name")
    val f_name: String,

    @SerializedName("l_name")
    val l_name: String,

    @SerializedName("specialty")
    val specialty: List<SpecialtyResponse>,
)

data class SpecialtyResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("specialty_id")
    val specialty_id: Int
)
