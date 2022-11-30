package br.com.alura.list

fun main() {
    val prateleira = Prateleira(genero = "Literatura", livros = listaDeLivros)

    val organizaPorAutor = prateleira.organizaPorAutor()
    val organizaPorAnoPublicacao = prateleira.organizaPorAnoPublicacao()

    organizaPorAutor.imprimeComMarcadores()
    organizaPorAnoPublicacao.imprimeComMarcadores()
}