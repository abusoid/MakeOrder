package com.example.makeorder.Repositories

import com.example.makeorder.Data.UserData

interface StartRepository {
    fun getUser(): UserData
    fun saveUser(user: UserData?)
}