package com.githubjjcdutra2015.service

import com.githubjjcdutra2015.events.PurchaseEvent
import com.githubjjcdutra2015.model.PurchaseModel
import com.githubjjcdutra2015.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchase: PurchaseModel) {
        purchaseRepository.save(purchase)

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchase))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

    fun findAllPurchaseCustomer(customerId: Int, pageable: Pageable) : Page<PurchaseModel> {
        return purchaseRepository.findAllByCustomer_Id(customerId, pageable)
    }
}
