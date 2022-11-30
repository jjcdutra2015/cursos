package br.com.alura.list

data class Prateleira(
    val genero: String,
    val livros: List<Livro>
) {
    fun organizaPorAutor(): List<Livro> {
        return this.livros.sortedBy { it.autor }
    }

    fun organizaPorAnoPublicacao(): List<Livro> {
        return this.livros.sortedBy { it.anoPublicacao }
    }
}