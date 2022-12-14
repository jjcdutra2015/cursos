package com.githubjjcdutra2015.controller

import com.githubjjcdutra2015.controller.mapper.PurchaseMapper
import com.githubjjcdutra2015.controller.request.PostPurchaseRequest
import com.githubjjcdutra2015.controller.response.PurchaseResponse
import com.githubjjcdutra2015.service.PurchaseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val mapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostPurchaseRequest) {
        purchaseService.create(mapper.toModel(request))
    }

    @GetMapping("/customer/{customerId}")
    fun findAllpurchaseCustomer(
        @PageableDefault(page = 0, size = 10) pageable: Pageable,
        @PathVariable customerId: Int
    ): Page<PurchaseResponse> {
        return mapper.toResponse(customerId, pageable)
    }
}