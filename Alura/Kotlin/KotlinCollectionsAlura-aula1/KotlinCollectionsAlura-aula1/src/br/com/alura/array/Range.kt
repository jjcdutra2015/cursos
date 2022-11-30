package br.com.alura.array

fun main() {
    val idades: IntArray = intArrayOf(10, 12, 18, 33, 40, 67)
    val maiorIdade = idades.max()
    println("Maior idade: $maiorIdade")

    val menorIdade = idades.min()
    println("Menor idade: $menorIdade")

    val media = idades.average()
    println("Media: $media")

    val todosMaiores = idades.all { it >= 18 }
    println("Todos maiores de idade? $todosMaiores")

    val existeMaior = idades.any { it >= 18 }
    println("Existe maior de idade? $existeMaior")

    val maiores = idades.filter { it >= 18 }
    println("Mariores de idade: $maiores")

    val busca = idades.find { it > 18 }
    println("$busca")

    val serie = 1.rangeTo(100)
    for (s in serie) {
        print("$s ")
    }
    println()

    val numeroPar = 0.until(100) step 2
    for (n in numeroPar) {
        print("$n ")
    }
    println()

    val numParRegressivo = 100 downTo 0 step 2
    numParRegressivo.forEach { print("$it ") }
    println()

    val intervalo = 1000.0..5000.0
    val salario = 3000.0
    if (salario in intervalo) {
        println("Dentro do intervalo")
    } else {
        println("Fora do intervalo")
    }
}