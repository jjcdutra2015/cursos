package com.githubjjcdutra2015.controller.response

import com.githubjjcdutra2015.enums.CustomerStatus

data class CustomerResponse(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)
