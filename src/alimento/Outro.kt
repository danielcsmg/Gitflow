package alimento

class Outro(override var nome: String = "", override var quantidade: Int = 0, override val tipo: String = "outros") : Alimento {
}