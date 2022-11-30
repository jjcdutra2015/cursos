package com.githubjjcdutra2015.controller.response

data class PageResponse<T>(
    val items: List<T>,
    val currentPage: Int,
    val totalItems: Long,
    val totalPages: Int
)
