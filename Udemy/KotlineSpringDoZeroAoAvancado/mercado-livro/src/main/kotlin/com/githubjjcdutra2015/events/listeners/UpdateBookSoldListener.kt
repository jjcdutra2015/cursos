package com.githubjjcdutra2015.events.listeners

import com.githubjjcdutra2015.events.PurchaseEvent
import com.githubjjcdutra2015.service.BookService
import com.githubjjcdutra2015.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateBookSoldListener(
    private val bookService: BookService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}