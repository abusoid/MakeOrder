package com.example.makeorder.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makeorder.Data.OrderData
import com.example.makeorder.Data.UserData

open class DataModel : ViewModel() {
    val userData: MutableLiveData<UserData> by lazy {
        MutableLiveData<UserData>()
    }
    val orderData: MutableLiveData<OrderData> by lazy {
        MutableLiveData<OrderData>()
    }
}