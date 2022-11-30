package com.example.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CustomerTest {

    @Test
    fun `should throw exception when id is null`() {
        val exception: Exception = assertThrows(
            Exception::class.java
        ) {
            Customer("", "Julio", Address("Jorge", 369, "28640-000", "Carmo"))
        }

        assertEquals("Id is required", exception.message)
    }
}