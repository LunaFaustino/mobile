interface Professor {
    fun passarConcurso()
}

open class Cidadao{
    fun direitoDeveres(){
        println("\nTodo cidadão tem direitos e deveres")
    }
}

class ProfFernando:Cidadao(),Professor{
    override fun passarConcurso() {
        println("\nFoi aprovado no concurso em SP")
    }

}

class ProfGuilherme:Cidadao(),Professor{
    override fun passarConcurso() {
        println("\nFoi aprovado no concurso em RN")
    }
}

fun main() {
    // Interface, um contrato que quando assumido deverá ser implementado
    val guilherme = ProfGuilherme()
    guilherme.direitoDeveres()
    guilherme.passarConcurso()
}