package com.example.aula2709.bancodedados

import com.example.aula2709.model.Produto

interface IProdutoDAO {
    fun salvar(produto: Produto):Boolean
    fun atualizar(produto: Produto):Boolean
    fun remover(id: Int):Boolean
    fun listar():List<Produto>
}