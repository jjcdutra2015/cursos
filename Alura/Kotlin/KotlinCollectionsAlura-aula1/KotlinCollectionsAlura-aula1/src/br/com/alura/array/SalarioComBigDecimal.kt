package br.com.alura.array

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val salarios = bigDecimalArrayOf("1500.55", "2000.00", "5000.00", "10000.00")
    println(salarios.contentToString())

    val aumento = "1.1".toBigDecimal()
    val salariosComAumento: Array<BigDecimal> = salarios.map { salario ->
        calculoAumentoRelativo(salario, aumento)
    }.toTypedArray()

    println(salariosComAumento.contentToString())

//    val gastosIniciais = salariosComAumento.somatoria()

    val gastosIniciais = salariosComAumento.reduce { acumulador, valor ->
        acumulador + valor
    }

    println(gastosIniciais)

    val meses = 6.toBigDecimal()
    val gastoTotal = salariosComAumento.fold(gastosIniciais) { acumulador, salario ->
        acumulador + (salario * meses).setScale(2, RoundingMode.UP)
    }

    println(gastoTotal)

    val media = salariosComAumento
        .sorted()
        .takeLast(3).toTypedArray()
        .media()

    println(media)
}

private fun calculoAumentoRelativo(
    salario: BigDecimal,
    aumento: BigDecimal
) = if (salario < "5000.00".toBigDecimal()) {
    salario + "500.00".toBigDecimal()
} else {
    (salario * aumento).setScale(2, RoundingMode.UP)
}