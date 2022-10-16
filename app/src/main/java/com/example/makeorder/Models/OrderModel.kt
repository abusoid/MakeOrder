package com.example.makeorder.Models

import com.example.makeorder.*
import com.example.makeorder.Data.OrderData
import com.example.makeorder.Repositories.ImplOrderRepository

class OrderModel(private val repository: ImplOrderRepository) : StartMVP.OrderModel {
    override fun saveOrder(order: OrderData?) {
        repository.saveOrder(order)
    }

    override fun getOrder(): OrderData? {
        return repository.getOrder()
    }


}


