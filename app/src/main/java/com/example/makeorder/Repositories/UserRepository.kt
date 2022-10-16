package com.example.makeorder.Repositories

import com.example.makeorder.Data.UserData

class UserRepository :StartRepository{
    private var user: UserData? = null
    override fun getUser(): UserData {
        return if (user == null) {
            UserData("N", "I")
        } else {
            this.user!!
        }
    }

    override fun saveUser(user: UserData?) {
        var user: UserData? = user
        if (user == null) {
            user = getUser()
        }
        this.user = user
    }
}