package com.example.makeorder

data class UserData(var email: String? = "", var password: String? = "", var phone: String? = "",
                    var name: String? = "", var drink: String? = "",
                    var sugar: Boolean = false, var milk: Boolean = false,
                    var lemon: Boolean = false, var stage: String? = "login", var drinkType: String? = "") {
    init {
        println("Start UserData")
        println("email: $email")
        this.password = password
        println("password: $password")
        this.drink = drink
        println("drink: $drink")
        this.sugar = sugar
        println("sugar: $sugar")
        this.milk = milk
        println("milk: $milk")
        this.lemon = lemon
        println("lemon: $lemon")
        this.name = name
        println("name: $name")
        this.phone = phone
        println("phone: $phone")
    }

}

