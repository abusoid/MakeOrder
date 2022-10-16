package com.example.makeorder.Repositories

import com.example.makeorder.Data.OrderData

class OrderRepository: ImplOrderRepository {
    private var order: OrderData? = null
    override fun saveOrder(order: OrderData?) {
        this.order = order
    }

    override fun getOrder(): OrderData? {
        return if(this.order!=null)
            this.order
        else
            OrderData("Fail","Drink",false,false,false,"FailType")
    }

}