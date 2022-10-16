package com.example.makeorder.Data

import java.io.Serializable

data class OrderData(var email: String? = "", var drink: String? = "",
                     var sugar: Boolean = false, var milk: Boolean = false,
                     var lemon: Boolean = false, var drinkType: String? = ""): Serializable {
    init {
        println("Start UserData")
        println("email: $email")
        this.drink = drink
        println("drink: $drink")
        this.sugar = sugar
        println("sugar: $sugar")
        this.milk = milk
        println("milk: $milk")
        this.lemon = lemon
        println("lemon: $lemon")
    }

}

