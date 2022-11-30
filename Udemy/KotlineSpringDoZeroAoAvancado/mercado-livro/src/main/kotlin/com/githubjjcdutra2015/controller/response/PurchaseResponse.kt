package com.githubjjcdutra2015.controller.response

import com.githubjjcdutra2015.model.BookModel

data class PurchaseResponse(
    var books: MutableList<BookModel>
)
