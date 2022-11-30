package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaFuncaoEscopo() {
    //    val endereco = Endereco(logradouro = "rua verguero", numero = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    run {
        println("Executando run sem extensão")
    }

    val endereco = Endereco()
        .apply {
            logradouro = "rua verguero"
            numero = 3185
        }

    with(endereco) {
        "$logradouro, $numero".toUpperCase()
    }.let(::println)

    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    ).filter(predicate = { endereco ->
        endereco.complemento.isNotEmpty()
    }).let(block = ::println)
}