package org.example

class Casa{
    //Propriedades ou atributos
    var cor:String
    var vagasGaragem:Int

    constructor(cor:String,vagasGaragem:Int){
        this.cor = cor
        this.vagasGaragem = vagasGaragem
    }

//    init {
//        this.cor = cor
//        this.vagasGaragem = vagasGaragem
//    }

    //Métodos
    fun detalhesCasa(){
        println("Cor: ${cor} - Vagas na garagem: ${vagasGaragem}")
    }

    fun abrirJanelas(){
        println("Abrindo janelas...")
    }

    fun abrirPortas(){
        println("Abrindo portas...")
    }

    fun abrirCasa(){
        this.abrirPortas()
        this.abrirJanelas()
    }
}

fun main() {
    var casaDoPresidente = Casa("Branca", 5)
    casaDoPresidente.detalhesCasa()

}