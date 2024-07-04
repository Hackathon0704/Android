package com.example.umc_hackathon.dreamshare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DreamShareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dreamshare Fragment"
    }
    val text: LiveData<String> = _text
}