package com.githubjjcdutra2015.controller

import com.githubjjcdutra2015.controller.request.PostBookRequest
import com.githubjjcdutra2015.controller.request.PutBookRequest
import com.githubjjcdutra2015.controller.response.BookResponse
import com.githubjjcdutra2015.controller.response.PageResponse
import com.githubjjcdutra2015.extensions.toBookModel
import com.githubjjcdutra2015.extensions.toPageResponse
import com.githubjjcdutra2015.extensions.toResponse
import com.githubjjcdutra2015.service.BookService
import com.githubjjcdutra2015.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid book: PostBookRequest) {
        val customer = customerService.findById(book.customerId)
        bookService.create(book.toBookModel(customer))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<BookResponse> {
        return bookService.findAll(pageable).map { it.toResponse() }.toPageResponse()
    }

    @GetMapping("/active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<BookResponse> {
        return bookService.findActives(pageable).map { it.toResponse() }.toPageResponse()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse {
        return bookService.findById(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}