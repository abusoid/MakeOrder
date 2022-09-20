package com.example.makeorder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val userData: MutableLiveData<UserData> by lazy {
        MutableLiveData<UserData>()
    }
}