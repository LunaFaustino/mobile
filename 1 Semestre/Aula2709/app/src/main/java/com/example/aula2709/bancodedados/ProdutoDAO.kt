package com.example.aula2709.bancodedados

import android.content.Context
import android.util.Log
import com.example.aula2709.model.Produto

class ProdutoDAO(context:Context) : IProdutoDAO {
    
    val escrita = DatabaseHelper(context).writableDatabase
    val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(produto: Produto): Boolean {
        val titulo = produto.titulo
        val descricao = produto.descricao

        try {
            val sql = "insert into produtos values(null, '$titulo', '$descricao')"
            escrita.execSQL(sql)
            Log.i("db_info","Produto inserido com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Erro ao inserir produto")
            return false
        }
        return true
    }

    override fun atualizar(produto: Produto): Boolean {
        TODO("Not yet implemented")
    }

    override fun remover(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Produto> {
        TODO("Not yet implemented")
    }
}