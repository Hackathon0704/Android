package com.example.umc_hackathon.interpretation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InterpretationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is interpretation Fragment"
    }
    val text: LiveData<String> = _text
}