package listacompras

/*Aqui chamamos de lista de compras apenas para ter as funções específicas da lista de compras que o sistema exige,
afinal é um sistema de lista de compras. Não confundir com o conceito de List do Kotlin*/
class ListaCompras {
    companion object {
        fun informarQuantidadeVerduraGrao(alimento: String): Double {
            println("Informe a quantidade de $alimento em gramas: ")
            val gramas: Double?
            return try {
                val input = readln()

                if (input.isEmpty() || input.isBlank()) {
                    throw UnsupportedOperationException("Não é permitido inserir valor vazio")
                }
                gramas = input.toDoubleOrNull()

                if (gramas != null) {
                    if (gramas < 0.0) {
                        throw UnsupportedOperationException("Não é permitido números negativos, tente novamente")
                    }
                    return gramas
                }
                throw NullPointerException("Valor não suportado")
            } catch (exception: NumberFormatException) {
                println("Não é permitido texto, somente número")
                informarQuantidadeVerduraGrao(alimento)
            } catch (exception: UnsupportedOperationException) {
                println(exception.message)
                informarQuantidadeVerduraGrao(alimento)
            } catch (exception: NullPointerException) {
                println(exception.message)
                informarQuantidadeVerduraGrao(alimento)
            }
        }

        fun informarNomeAlimento(alimento: String): String {
            return try {
                println("Informe o tipo $alimento a ser adicionado na lista: ")
                val nome = readln()

                if (nome.isEmpty() || nome.isBlank()) {
                    throw UnsupportedOperationException("Não é permitido inserir valor vazio")
                }
                return nome
            }catch (exception: UnsupportedOperationException){
                println(exception.message)
                informarNomeAlimento(alimento)
            }
        }


        fun informarQuantidadeLegumeOutros(alimento: String): Int {
            println("Informe a quantidade de $alimento: ")
            val qtd: Int?
            return try {
                val input = readln()

                if (input.isEmpty() || input.isBlank()) {
                    throw UnsupportedOperationException("Não é permitido inserir valor vazio")
                }
                qtd = input.toIntOrNull()

                if (qtd != null) {
                    if (qtd < 0) {
                        throw UnsupportedOperationException("Não é permitido números negativos, tente novamente")
                    }
                    return qtd
                }
                throw NullPointerException("Valor não suportado")
            } catch (exception: NumberFormatException) {
                println("Não é permitido texto, somente número")
                informarQuantidadeLegumeOutros(alimento)
            } catch (exception: UnsupportedOperationException) {
                println(exception.message)
                informarQuantidadeLegumeOutros(alimento)
            } catch (exception: NullPointerException) {
                println(exception.message)
                informarQuantidadeLegumeOutros(alimento)
            }
        }

    }
}