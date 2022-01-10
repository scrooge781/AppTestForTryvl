package scrooge.my.apptest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import scrooge.my.apptest.domain.SaveDataLocalUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch
import scrooge.my.apptest.data.model.Specialist
import scrooge.my.apptest.data.model.Specialty
import scrooge.my.apptest.domain.GetSpecialistUseCase
import scrooge.my.apptest.domain.GetSpecialityUseCase

@HiltViewModel
class MainViewModel @Inject
constructor(
    private val saveDataLocalUseCase: SaveDataLocalUseCase,
    private val getSpecialityUseCase: GetSpecialityUseCase,
    private val getSpecialistUseCase: GetSpecialistUseCase
) : ViewModel() {

    private val _listSpeciality = MutableLiveData<List<Specialty>>()
    val listSpecialty: LiveData<List<Specialty>>
        get() = _listSpeciality

    private val _listSpecialist = MutableLiveData<List<Specialist>>()
    val listSpecialist: LiveData<List<Specialist>>
        get() = _listSpecialist

    private val _speciality = MutableLiveData<String>()
    val speciality: LiveData<String>
        get() = _speciality

    fun getSpeciality() {
        viewModelScope.launch {
            var listSpecialty = getSpecialityUseCase.getSpeciality()
            if (!listSpecialty.isNullOrEmpty()) {
                _listSpeciality.value = listSpecialty
            } else {
                saveDataLocalUseCase.saveDataLocal()

                listSpecialty = getSpecialityUseCase.getSpeciality()
                _listSpeciality.postValue(listSpecialty)
            }
        }

    }

    fun getSpecialist(speciality_id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val listSpecialist = getSpecialistUseCase.getSpecialist(speciality_id)
            _listSpecialist.postValue(listSpecialist)
        }
    }

    fun getSpecialityId(speciality_id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val speciality = getSpecialityUseCase.getSpecialityId(speciality_id)
            _speciality.postValue(speciality.name)
        }
    }
}