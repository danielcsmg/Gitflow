package menu

import listacompras.ListaCompras.Companion.informarNomeAlimento
import listacompras.ListaCompras.Companion.informarQuantidadeLegumeOutros
import listacompras.ListaCompras.Companion.informarQuantidadeVerduraGrao
import kotlin.system.exitProcess

class Menu {
    companion object {
        private var listaAlimentos: HashMap<String, Number> = HashMap()

        fun menu() {
            println("Digite o tipo de alimento que deseja incluir na lista")
            println("Verdura")
            println("Legume")
            println("Grão")
            println("Outros")
            println("Ver lista")
            println("Sair")
            val alimento: String
            try {
                alimento = readln().lowercase()

                if (alimento.isEmpty() || alimento.isBlank()) {
                    throw UnsupportedOperationException("Não é permitido inserir valor vazio")
                }

                when (alimento) {
                    "verdura", "grão", "grao" -> {
                        /*Não é para mexer aqui*/
                        val quantidade = informarQuantidadeVerduraGrao(alimento)
                        val nome = informarNomeAlimento(alimento)

                        listaAlimentos[nome] = quantidade
                        menu()
                    }
                    "legume", "outros" -> {
                        val quantidade = informarQuantidadeLegumeOutros(alimento)
                        val nome = informarNomeAlimento(alimento)

                        listaAlimentos[nome] = quantidade
                        menu()
                    }
                    "ver lista" -> {
                        showAlimentos()
                        menu()

                    }

                    "sair" -> {
                        println("Até breve!")
                        exitProcess(0)
                    }
                    else -> throw IllegalArgumentException("Tipo de alimento inválido")

                }
            } catch (e: IllegalArgumentException) {
                println(e.message)
                menu()
            } catch (e: UnsupportedOperationException) {
                println(e.message)
                menu()
            }
        }

        private fun showAlimentos() {
            try {
                if(listaAlimentos.isEmpty()){
                    throw UnsupportedOperationException("Lista está vazia")
                }
                listaAlimentos.forEach { (nomeAlimento, qtd) ->
                    println("nome : $nomeAlimento , quantidade : $qtd")
                }
            }catch (e: UnsupportedOperationException){
                println(e.message)
            }catch (e: Exception){
                println("Erro não encontrado")
            }

        }
    }
}