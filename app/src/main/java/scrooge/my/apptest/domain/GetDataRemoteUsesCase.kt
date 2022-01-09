package scrooge.my.apptest.domain

import scrooge.my.apptest.data.model.Response
import scrooge.my.apptest.data.model.SpecialistResponse
import scrooge.my.apptest.data.remote.ParsingJson
import javax.inject.Inject

class GetDataRemoteUsesCase (
    private val json: ParsingJson
) {

    fun getDataRemote(): List<SpecialistResponse>? {
        return json.getAssetJsonData()?.response
    }
}