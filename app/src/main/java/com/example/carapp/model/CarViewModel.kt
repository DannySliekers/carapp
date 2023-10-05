package com.example.carapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carapp.network.CarApi
import kotlinx.coroutines.launch
import java.lang.Exception

class CarViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status : LiveData<String> = _status

    init {
        getCars()
    }

    private fun getCars() {
        viewModelScope.launch {
            try {
                val listResult = CarApi.retrofitService.getCars()
                _status.value = listResult
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}