package menu

import alimento.*
import listacompras.ListaCompras.Companion.informarNomeAlimento
import listacompras.ListaCompras.Companion.informarQuantidadeLegumeOutros
import listacompras.ListaCompras.Companion.informarQuantidadeVerduraGrao
import kotlin.system.exitProcess

class Menu {
    companion object {
        private var listaAlimentos = HashMap<String, Alimento>()

        fun menu() {
            println("Digite o tipo de alimento que deseja incluir na lista")
            println("Verdura")
            println("Legume")
            println("Grão")
            println("Outros")
            println("Ver lista")
            println("Sair")
            val valorAlimentos: String
            try {
                valorAlimentos = readln().lowercase()

                if (valorAlimentos.isEmpty() || valorAlimentos.isBlank()) {
                    throw UnsupportedOperationException("Não é permitido inserir valor vazio")
                }

                when (valorAlimentos) {
                    "verdura" -> {
                        val verdura = Verdura()
                        val quantidade = informarQuantidadeVerduraGrao(verdura)
                        verdura.quantidade = quantidade
                        val nome = informarNomeAlimento(verdura)
                        verdura.nome = nome

                        listaAlimentos[nome] = verdura
                        menu()
                    }

                    "grão", "grao" -> {
                        val grao = Grao()
                        val quantidade = informarQuantidadeVerduraGrao(grao)
                        grao.quantidade = quantidade
                        val nome = informarNomeAlimento(grao)
                        grao.nome = nome

                        listaAlimentos[nome] = grao
                        menu()
                    }

                    "legume" -> {
                        val legume = Legume()
                        val quantidade = informarQuantidadeLegumeOutros(legume)
                        legume.quantidade = quantidade
                        val nome = informarNomeAlimento(legume)
                        legume.nome = nome

                        listaAlimentos[nome] = legume
                        menu()
                    }

                    "outros" -> {
                        val outros = Outro()
                        val quantidade = informarQuantidadeLegumeOutros(outros)
                        outros.quantidade = quantidade
                        val nome = informarNomeAlimento(outros)
                        outros.nome = nome

                        listaAlimentos[nome] = outros
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
                if (listaAlimentos.isEmpty()) {
                    throw UnsupportedOperationException("Lista está vazia")
                }
                listaAlimentos.forEach { (nome, alimento) ->
                    println("nome : ${alimento.nome} , quantidade : ${alimento.quantidade}")
                }
            } catch (e: UnsupportedOperationException) {
                println(e.message)
            } catch (e: Exception) {
                println("Erro não encontrado")
            }

        }
    }
}