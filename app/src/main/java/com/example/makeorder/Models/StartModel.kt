package com.example.makeorder.Models

import com.example.makeorder.*
import com.example.makeorder.Repositories.StartRepository

class StartModel(private val repository: StartRepository) : StartMVP.UserModel {
    override fun saveUser(email: String?, password: String, phone: String?, name: String?) {
        repository.saveUser(UserData(email, password, phone, name))
    }
    override fun saveUser(email: String?, password: String) {
        repository.saveUser(UserData(email, password))
    }

    override fun getUser(): UserData {
        return repository.getUser()
    }
}


