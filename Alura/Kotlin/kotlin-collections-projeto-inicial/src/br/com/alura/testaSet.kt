package br.com.alura

fun testaSet() {
    val assistiramCursoAndroid: Set<String> = setOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: Set<String> = setOf("Alex", "Paulo", "Maria")
    val assistiramAmbos: Set<String> = assistiramCursoAndroid + assistiramCursoKotlin
    println(assistiramAmbos)

    println(assistiramCursoAndroid union assistiramCursoKotlin)

    println(assistiramCursoAndroid subtract assistiramCursoKotlin)

    println(assistiramCursoKotlin subtract assistiramCursoAndroid)

    println(assistiramCursoAndroid intersect assistiramCursoKotlin)
}