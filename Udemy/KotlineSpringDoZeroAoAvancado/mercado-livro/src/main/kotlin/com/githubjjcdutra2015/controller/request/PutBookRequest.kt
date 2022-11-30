package com.githubjjcdutra2015.controller.request

import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,
    val price: BigDecimal?
)
