package com.githubjjcdutra2015.repository

import com.githubjjcdutra2015.enums.BookStatus
import com.githubjjcdutra2015.model.BookModel
import com.githubjjcdutra2015.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}