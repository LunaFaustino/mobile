package org.example

open class Animal(){
    var cor:String = ""
    var idade:Int = 0
    var peso:Double = 0.00

    open fun dormir(){
        println("Dormindo...")
    }
}

class Cachorro:Animal(){

    override fun dormir(){
        super.dormir()
        println("como um cachorro...")
    }

    fun latir(){
        println("au au au au")
    }
}

class Gato:Animal(){

    fun miar(){
        println("miau miau miau")
    }
}

fun main(){
    var cachorro1 = Cachorro()
    cachorro1.cor = "Caramelo"
    cachorro1.idade = 2
    cachorro1.peso = 3.400
    cachorro1.latir()
    cachorro1.dormir()
}