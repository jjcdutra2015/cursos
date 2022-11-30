package br.com.alura

fun testaCopia() {
    val banco = BancoDeNomes()
    val nomeSalvo: Collection<String> = banco.nomes
    banco.salva("Julio")
    println(nomeSalvo)
    println(BancoDeNomes().nomes)
}

class BancoDeNomes {

    companion object {
        private val dados = mutableListOf<String>()
    }

    val nomes: Collection<String> get() = dados.toList()

    fun salva(nome: String) {
        dados.add(nome)
    }
}