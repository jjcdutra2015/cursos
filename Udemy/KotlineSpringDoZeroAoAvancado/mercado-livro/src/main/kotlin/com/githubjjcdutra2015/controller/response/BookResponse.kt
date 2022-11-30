package com.githubjjcdutra2015.controller.response

import com.githubjjcdutra2015.enums.BookStatus
import com.githubjjcdutra2015.model.CustomerModel
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null
)
