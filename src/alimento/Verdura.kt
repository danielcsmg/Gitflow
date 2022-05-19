package alimento

class Verdura(override var nome: String = "", override var quantidade: Double = 0.0, override val tipo: String = "verdura") :
    Alimento {
}