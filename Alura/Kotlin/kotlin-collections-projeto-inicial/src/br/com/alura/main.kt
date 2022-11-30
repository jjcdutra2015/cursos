package br.com.alura

fun main() {

    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0)
    )
    println(pedidos)

    val pedidosAssociadosMap: Map<Int, Pedido> = pedidos.associate { pedido ->
        Pair(pedido.numero, pedido)
    }
    println(pedidosAssociadosMap)
    println(pedidosAssociadosMap[1])

    val pedidosAssociadosMapBy: Map<Int, Pedido> = pedidos.associateBy { pedido -> pedido.numero }
    println(pedidosAssociadosMapBy)
    println(pedidosAssociadosMap[1])

    val pedidoFreteGratis: Map<Pedido, Boolean> = pedidos.associateWith { pedido ->
        pedido.valor > 50.0
    }
    println(pedidoFreteGratis)
    println(pedidoFreteGratis[Pedido(2, 60.0)])

    val pedidoFreteGratisAgrupado: Map<Boolean, List<Pedido>> = pedidos.groupBy { pedido ->
        pedido.valor > 50.0
    }
    println(pedidoFreteGratisAgrupado)
    println(pedidoFreteGratisAgrupado[true])

    val nomes = listOf(
        "Alex",
        "Fran",
        "Gui",
        "Maria",
        "Mario",
        "Paulo",
        "Ana"
    )

    val agenda = nomes.groupBy { nome ->
        nome.first()
    }
    println(agenda['A'])
}

data class Pedido(
    val numero: Int,
    val valor: Double
)