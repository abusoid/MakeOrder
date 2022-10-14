package com.example.makeorder

data class OrderData(var email: String? = "", var drink: String? = "",
                     var sugar: Boolean = false, var milk: Boolean = false,
                     var lemon: Boolean = false, var stage: String? = "login", var drinkType: String? = "") {
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

