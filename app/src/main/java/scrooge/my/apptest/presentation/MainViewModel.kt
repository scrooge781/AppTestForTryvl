package scrooge.my.apptest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import scrooge.my.apptest.domain.SaveDataLocalUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject
constructor(private val saveDataLocalUseCase: SaveDataLocalUseCase) : ViewModel() {


    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun saveData() {
        viewModelScope.launch {
            saveDataLocalUseCase.saveDataLocal()
            _shouldCloseScreen.value = Unit

        }
    }
}