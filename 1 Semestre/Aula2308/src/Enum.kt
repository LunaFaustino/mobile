//Enum = conjunto de constantes
enum class StatusPedido{
    APROVADO, REPROVADO, PENDENTE
}

class Pedido{
    var status:StatusPedido = StatusPedido.APROVADO
}

fun main(){

    val pedido01 = Pedido()
    println(pedido01.status)

}