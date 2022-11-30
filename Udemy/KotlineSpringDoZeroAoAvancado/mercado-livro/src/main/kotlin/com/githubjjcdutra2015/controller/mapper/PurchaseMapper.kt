package com.githubjjcdutra2015.controller.mapper

import com.githubjjcdutra2015.controller.request.PostPurchaseRequest
import com.githubjjcdutra2015.controller.response.PurchaseResponse
import com.githubjjcdutra2015.enums.BookStatus
import com.githubjjcdutra2015.model.PurchaseModel
import com.githubjjcdutra2015.service.BookService
import com.githubjjcdutra2015.service.CustomerService
import com.githubjjcdutra2015.service.PurchaseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val customerService: CustomerService,
    private val bookService: BookService,
    private val purchaseService: PurchaseService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        val activeBooks = books.filter { it.status == BookStatus.ATIVO }

        return PurchaseModel(
            customer = customer,
            books = activeBooks.toMutableList(),
            price = activeBooks.sumOf { it.price }
        )
    }

    fun toResponse(customerId: Int, pageable: Pageable): Page<PurchaseResponse> {
        val purchaseModels = purchaseService.findAllPurchaseCustomer(customerId, pageable)

        return purchaseModels.map {
            PurchaseResponse(
                books = it.books
            )
        }
    }
}