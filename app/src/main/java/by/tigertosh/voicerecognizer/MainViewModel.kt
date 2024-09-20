package by.tigertosh.voicerecognizer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _russianText = MutableLiveData<String>()
    val russianText: LiveData<String> = _russianText

    private val _englishText = MutableLiveData<String>()
    val englishText: LiveData<String> = _englishText

    fun setRussianText(text: String) {
        _russianText.value = text
        translateToEnglish(text)
    }

    private fun translateToEnglish(russianText: String) {
        viewModelScope.launch {
            _englishText.value = "$russianText (Translated)"
        }
    }
}