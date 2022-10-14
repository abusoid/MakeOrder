package com.example.makeorder.Repositories

import com.example.makeorder.UserData

interface StartRepository {
    fun getUser(): UserData
    fun saveUser(user:UserData?)
}