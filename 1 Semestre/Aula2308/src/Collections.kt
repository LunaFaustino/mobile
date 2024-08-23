fun main(){

    //listOf -> imutável, tamanho fixo, e não pode ser alterado

    var estadosBr = listOf("RS","SC","PR")

    //arrayListOf -> mutável, tamanho não fixo e pode ser alterado

    val nomesAlunos = arrayListOf("Larissa", "Luna", "Deyckson")
    nomesAlunos.add("Lucas")
    nomesAlunos.remove("Larissa")
    nomesAlunos[1] = "Gabriel"


    //set -> não fica em ordem, não permite duplicados, mais rápida que o arrayListOf

    val idadeAlunos = hashSetOf(10,15,22,30,30,55,58)


    //map -> estrutura de chave/valor

    val mapa = hashMapOf(
        "Leão" to "Rei da Floresta",
        "Leoa" to "Rainha da Floresta",
        "Cachorro" to "Melhor amigo do homem",
        "Gato" to "Odeia o homem"
    )

    mapa.put("Panda","Dragão Guerreiro")
    mapa["Cobra"] = "Venenosa"
    mapa.remove("Cachorro")

    for (item in mapa){
        //println(item.key)
        println(item.value)
    }

}