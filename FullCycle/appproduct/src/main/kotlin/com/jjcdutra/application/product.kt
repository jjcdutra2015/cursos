package com.jjcdutra.application

import java.math.BigDecimal

interface ProductInterface {
    fun isValid()
    fun enable()
    fun disable()
    fun GetId(): String
    fun GetName(): String
    fun GetStatus(): String
    fun GetPrice(): BigDecimal
}

const val DISABLED = "disabled"
const val ENABLED = "enabled"

data class Product(
    var id: String?,
    var name: String,
    var status: String,
    var price: BigDecimal
) : ProductInterface {

    override fun isValid() {
        if (this.status == "") this.status = DISABLED

        if (this.status != ENABLED && this.status != DISABLED) throw Exception("The status must be enabled or disabled")

        if (this.price < BigDecimal.ZERO) throw Exception("The price must be greater or equal zero")
    }

    override fun enable() {
        if (this.price > BigDecimal.ZERO) {
            this.status = ENABLED
        } else {
            throw Exception("The price must be greater than zero to enable the product")
        }
    }

    override fun disable() {
        if (this.price == BigDecimal.ZERO) this.status = DISABLED
        else throw Exception("The price must be zero in order to have product disabled")
    }

    override fun GetId(): String {
        return this.id!!
    }

    override fun GetName(): String {
        return this.name
    }

    override fun GetStatus(): String {
        return this.status
    }

    override fun GetPrice(): BigDecimal {
        return this.price
    }
}