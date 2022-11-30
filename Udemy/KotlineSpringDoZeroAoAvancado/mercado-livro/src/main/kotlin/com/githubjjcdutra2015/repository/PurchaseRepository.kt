package com.githubjjcdutra2015.repository

import com.githubjjcdutra2015.model.PurchaseModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<PurchaseModel, Int> {
    fun findAllByCustomer_Id(customerId: Int, pageable: Pageable): Page<PurchaseModel>
}
