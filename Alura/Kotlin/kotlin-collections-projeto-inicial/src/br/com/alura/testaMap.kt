package br.com.alura

fun testaMap(pedidos: MutableMap<Int, Double>) {
    val pedido = pedidos[1]
    println(pedido)

    for (p in pedidos) {
        println("Número do pedido: ${p.key}")
        println("Valor do pedido: ${p.value}")
    }

    pedidos[4] = 70.0
    println(pedidos)
    pedidos.put(5, 80.0)
    println(pedidos)
    pedidos[1] = 100.0
    println(pedidos)
    pedidos.putIfAbsent(6, 200.0)
    println(pedidos)
    pedidos.putIfAbsent(6, 300.0)
    println(pedidos)

    pedidos.remove(6)
    println(pedidos)
    pedidos.remove(3)
    println(pedidos)
}

fun testaComportamentoMap() {
    //infix to perda de performance
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 64.0),
        3 to 50.0,
        4 to 100.0,
        5 to 150.0,
        6 to 80.0
    )
//    println(pedidos)
    println(pedidos.getValue(4))

    val mensagem: Double? = pedidos.getOrElse(6) {
        -1.0
    }
    println(mensagem)

    println(pedidos.getOrDefault(0, "Não existe"))

    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 50.0
    }
    println(pedidosFiltrados)

    val pedidosPares = pedidos.filterKeys { numero ->
        numero % 2 == 0
    }
    println(pedidosPares)

    val pedidosAcima = pedidos.filterValues { valor ->
        valor > 50.0
    }
    println(pedidosAcima)

    println(pedidos + Pair(7, 90.0)) // Não altera o original
    println(pedidos)

    println(pedidos + mapOf(8 to 55.0, 9 to 37.0))
    println(pedidos)

    println(pedidos - 1)
    println(pedidos)

//    println(pedidos - listOf(7, 8, 9))
//    println(pedidos)
}