package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    val endereco: Endereco? = Endereco()
    endereco?.logradouro?.length

    endereco?.let {
        println(it.logradouro.length)
    }
}