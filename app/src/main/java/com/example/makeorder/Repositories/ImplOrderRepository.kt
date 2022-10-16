package com.example.makeorder.Repositories

import com.example.makeorder.Data.OrderData

interface ImplOrderRepository {
    fun getOrder(): OrderData?
    fun saveOrder(order: OrderData?)
}