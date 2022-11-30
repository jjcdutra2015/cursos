package com.jjcdutra.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class ProductTest {

    private lateinit var product: Product

    @BeforeEach
    fun setup() {
        product = Product(
            id = null,
            name = "Product",
            status = DISABLED,
            price = BigDecimal(10.0)
        )
    }

    @Test
    fun `should enable when price greater than zero`() {
        product.enable()

        assertEquals("enabled", product.status)
    }

    @Test
    fun `should throw exception when price is less than zero`() {
        product.price = BigDecimal.ZERO

        val exception = assertThrows<Exception> {
            product.enable()
        }

        assertEquals("The price must be greater than zero to enable the product", exception.message)
    }

    @Test
    fun `should disabled when price equal zero`() {
        product.price = BigDecimal.ZERO

        assertEquals("disabled", product.status)
    }

    @Test
    fun `should throw exception when price is greater than zero`() {
        val exception = assertThrows<Exception> {
            product.disable()
        }

        assertEquals("The price must be zero in order to have product disabled", exception.message)
    }
}