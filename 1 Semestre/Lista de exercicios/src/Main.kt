// EXERCÍCIO 1

//fun calcularDesconto(valor: Double, desconto: Double): Double {
//    return valor - (valor*(desconto/100))
//}
//
//fun main() {
//
//    println("Informe o valor do produto: ")
//    val valorProduto = readLine()?.toDouble()
//
//    println("Informe o percentual de desconto: ")
//    val percentualDesconto = readLine()?.toDouble()
//
//    if (valorProduto != null && percentualDesconto != null) {
//        val valorFinal = calcularDesconto(valorProduto, percentualDesconto)
//        println("O valor final do produto é: R$ ${valorFinal}")
//    } else {
//        println("Entrada inválida. Use somente números")
//    }
//
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 2

//fun main(){
//
//    var soma = 0
//
//    while (true){
//        println("Informe um número para somar ou 0 para sair:")
//        val valor = readLine()?.toIntOrNull()
//
//        if (valor == null){
//            println("Por favor, insira um número")
//            continue
//        }
//
//        if (valor == 0){
//            break
//        }
//
//        soma += valor
//    }
//
//    println("A soma dos valores informados é: $soma")
//
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 3

//fun avaliaResultadoIf(nota:Int){
//    if (nota == 1){
//        println("Essa nota é péssima")
//    } else if(nota == 2){
//        println("Essa nota é ruim")
//    } else if(nota == 3){
//        println("Essa nota é satisfatória")
//    } else if(nota == 4){
//        println("Essa nota é boa")
//    } else if(nota == 5){
//        println("Essa nota é ótima")
//    } else {
//        println("Nota inválida")
//    }
//}
//fun main(){
//
//    println("Digite uma nota de 1 a 5: ")
//    val nota = readln().toInt()
//
//    avaliaResultadoIf(nota)
//
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 4

//fun calculaMediaWhile(nota: Int){
//    when (nota){
//        1 -> println("Essa nota é péssima")
//        2 -> println("Essa nota é ruim")
//        3 -> println("Essa nota é satisfatória")
//        4 -> println("Essa nota é boa")
//        5 -> println("Essa nota é ótima")
//        else -> println("Nota inválida")
//    }
//
//}
//
//fun main(){
//
//    println("Digite uma nota de 1 a 5: ")
//    val nota = readln().toInt()
//
//    calculaMediaWhile(nota)
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 5

//fun calcularMediaWhile(){
//    var total = 0.0
//    var contador = 0
//
//    while (true){
//        println("Informe um número positivo ou 0 para sair: ")
//        val numero = readln().toDouble()
//
//        if (numero == null || numero < 0){
//            println("Por favor, insira um número válido")
//            continue
//        }
//
//        if (numero == 0.0){
//            break
//        }
//
//        total += numero
//        contador++
//    }
//
//    val media = if (contador > 0) total / contador else 0.0
//
//    println("Contador: $contador")
//    println("Valor total: $total")
//    println("Media: $media")
//}
//
//fun main(){
//    calcularMediaWhile()
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 6

//fun fazerLoop(){
//    println("Digite um número: ")
//    val numero = readln().toInt()
//    var comeco = 0
//
//    while (numero != comeco){
//        comeco += 2
//        println(comeco)
//    }
//
//}
//fun main(){
//    fazerLoop()
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 7

//fun fazerLoop(){
//
//    val produtos = hashMapOf(
//        "Iphone 13" to 3000.00,
//    )
//
//    while (true){
//        println("Informe o nome do produto ou 'sair' para finalizar: ")
//        val nome = readln()
//
//        if (nome.lowercase() == "sair"){
//            println("Fechando o sistema...")
//            break
//        }
//
//        println("Informe o preço do produto: ")
//        val preco = readln().toDouble()
//
//        if (preco == null || preco <= 0) {
//            println("Preço inválido. Por favor, insira um valor válido.")
//        }
//
//        produtos[nome] = preco
//
//    }
//
//    println("\nProdutos e preços informados: ")
//    for ((nome, preco) in produtos){
//        println("Produto: $nome - Preço: R$$preco")
//    }
//
//    val media = if (produtos.isNotEmpty()) produtos.values.average() else 0.0
//    println("\nValor médio dos produtos: R$$media")
//
//    val produtosOrdenados = produtos.toList().sortedBy { it.second }
//
//    println("\nProdutos ordenados por preço crescente:")
//    var index = 0
//    while (index < produtosOrdenados.size){
//        val (nome, preco) = produtosOrdenados[index]
//        println("Produto: $nome - Preço: R$$preco")
//        index++
//    }
//}
//
//fun main(){
//    fazerLoop()
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 8

//open class Formas{
//    var cor: String = ""
//    var quantLados: Int = 0
//}
//
//class Retangulo(): Formas(){
//}
//
//class Quadrado(): Formas(){
//}
//
//fun main(){
//    val retangulo1 = Retangulo()
//    retangulo1.cor = "Azul"
//    retangulo1.quantLados = 4
//
//    val retangulo2 = Retangulo()
//    retangulo2.cor = "Rosa"
//    retangulo2.quantLados = 4
//
//    val retangulo3 = Retangulo()
//    retangulo3.cor = "Laranja"
//    retangulo3.quantLados = 4
//
//    val quadrado1 = Quadrado()
//    quadrado1.cor = "Verde"
//    quadrado1.quantLados = 4
//
//    val quadrado2 = Quadrado()
//    quadrado2.cor = "Vermelho"
//    quadrado2.quantLados = 4
//
//    val quadrado3 = Quadrado()
//    quadrado3.cor = "Preto"
//    quadrado3.quantLados = 4
//
//    println("Retangulo 1 é ${retangulo1.cor} e tem ${retangulo1.quantLados} lados")
//    println("Retangulo 2 é ${retangulo2.cor} e tem ${retangulo2.quantLados} lados")
//    println("Retangulo 3 é ${retangulo3.cor} e tem ${retangulo3.quantLados} lados")
//    println("Quadrado 1 é ${quadrado1.cor} e tem ${quadrado1.quantLados} lados")
//    println("Quadrado 2 é ${quadrado2.cor} e tem ${quadrado2.quantLados} lados")
//    println("Quadrado 3 é ${quadrado3.cor} e tem ${quadrado3.quantLados} lados")
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 9

//class Pessoa(nome: String, sobrenome: String, idade: Int, altura: Double, peso:Double) {
//    var nome: String
//    var sobrenome: String
//    var idade: Int
//    var altura: Double
//    var peso : Double
//
//    init {
//        this.nome = nome
//        this.sobrenome = sobrenome
//        this.idade = idade
//        this.altura = altura
//        this.peso = peso
//    }
//
//    fun detalhes(){
//        println("Nome: $nome \nSobrenome: $sobrenome \nIdade: $idade \nAltura: $altura \nPeso: $peso")
//    }
//
//}
//
//fun main(){
//    println("Informe o seu nome: ")
//    val nome = readln()
//
//    println("Informe o seu sobrenome: ")
//    val sobrenome = readln()
//
//    println("Informe sua idade: ")
//    val idade = readln().toInt()
//
//    println("Informe sua altura: ")
//    val altura = readln().toDouble()
//
//    println("Informe seu peso: ")
//    val peso = readln().toDouble()
//
//    val pessoa1 = Pessoa(nome, sobrenome, idade, altura, peso)
//    println(pessoa1.detalhes())
//}

// ---------------------------------------------------------------------------

// EXERCÍCIO 10

//fun saudacao():String{
//    println("Digite um nome")
//    val nome = readln()
//
//    println("Digite uma cor")
//    val cor = readln()
//
//    println("Digite um mês")
//    val mes = readln()
//
//    return "Olá, meu nome é ${nome.capitalize()}, minha cor favorita é ${cor.lowercase()} e nasci em ${mes.capitalize()}"
//}
//
//fun main(){
//    println(saudacao())
//}