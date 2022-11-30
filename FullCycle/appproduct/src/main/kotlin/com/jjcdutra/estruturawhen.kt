package com.jjcdutra

fun main() {

    val pessoa: Pessoa? = null
    println(pessoa?.nome ?: "teste")
}

class Pessoa(
    val nome: String,
    val idade: Int
)