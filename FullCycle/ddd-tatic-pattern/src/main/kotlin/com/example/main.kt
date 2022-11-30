package com.example

import com.example.entity.Address
import com.example.entity.Customer
import com.example.entity.Order
import com.example.entity.OrderItem

fun main() {
    val customer = Customer(
        id = "123",
        name = "Julio Dutra",
        address = Address(
            street = "Rua dois",
            number = 2,
            zip = "12345-678",
            city = "Carmo"
        )
    )
    customer.activate()

    val item1 = OrderItem(id = "1", name = "Item 1", 10)
    val item2 = OrderItem(id = "2", name = "Item 2", 15)

    Order(id = "1", customerId = "123", arrayListOf(item1, item2))
}