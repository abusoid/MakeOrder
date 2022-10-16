package com.example.makeorder.Data

import java.io.Serializable

data class UserData(var email: String? = "", var password: String? = "", var phone: String? = "",
                    var name: String? = "", var stage: String? = ""): Serializable {
    init {
        println("Start UserData")
        println("email: $email")
        this.password = password
        println("password: $password")
        this.name = name
        println("name: $name")
        this.phone = phone
        println("phone: $phone")
    }

}

