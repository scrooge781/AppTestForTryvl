package scrooge.my.apptest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import scrooge.my.apptest.domain.SaveDataLocalUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch
import scrooge.my.apptest.data.model.Specialist
import scrooge.my.apptest.data.model.Specialty
import scrooge.my.apptest.domain.GetSpecialist
import scrooge.my.apptest.domain.GetSpeciality

@HiltViewModel
class MainViewModel @Inject
constructor(
    private val saveDataLocalUseCase: SaveDataLocalUseCase,
    private val getSpeciality: GetSpeciality,
    private val getSpecialist: GetSpecialist
) : ViewModel() {

    private val _listSpeciality = MutableLiveData<List<Specialty>>()
    val listSpecialty: LiveData<List<Specialty>>
        get() = _listSpeciality

    private val _listSpecialist = MutableLiveData<List<Specialist>>()
    val listSpecialist: LiveData<List<Specialist>>
        get() = _listSpecialist

    fun getSpeciality() {
        viewModelScope.launch {
            var listSpecialty = getSpeciality.getSpeciality()
            if (!listSpecialty.isNullOrEmpty()) {
                _listSpeciality.value = listSpecialty
            } else {
                saveDataLocalUseCase.saveDataLocal()

                listSpecialty = getSpeciality.getSpeciality()
                _listSpeciality.value = listSpecialty
            }
        }

    }

    fun getSpecialist(speciality_id: Int) {
        viewModelScope.launch {
            _listSpecialist.value = getSpecialist.getSpecialist(speciality_id)
        }
    }
}