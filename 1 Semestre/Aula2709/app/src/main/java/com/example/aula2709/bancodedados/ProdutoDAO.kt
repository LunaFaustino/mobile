package com.example.aula2709.bancodedados

import android.content.Context
import android.util.Log
import com.example.aula2709.model.Produto

class ProdutoDAO(context:Context) : IProdutoDAO {
    
    val escrita = DatabaseHelper(context).writableDatabase
    val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(produto: Produto): Boolean {
        val titulo = produto.titulo

        try {
            val sql = "insert into ${DatabaseHelper.TABELA} values(null, '$titulo', 'SEM DESCRIÇÃO')"
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

        val titulo = produto.titulo

        try {
            val sql = "update ${DatabaseHelper.TABELA} set ${DatabaseHelper.TITULO} = '$titulo' where ${DatabaseHelper.ID_PRODUTO} = 2;"
            escrita.execSQL(sql)
            Log.i("db_info","Nome do produto atualizado com sucesso.")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Erro ao atualizar produto")
            return false
        }
        return true
    }

    override fun remover(id: Int): Boolean {

        val sql = "delete from ${DatabaseHelper.TABELA} where ${DatabaseHelper.ID_PRODUTO} = $id;"

        try {
            escrita.execSQL(sql)
            Log.i("db_info","Produto deletado com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Erro ao deletar.")
            return false
        }
        return true
    }

    override fun listar(): List<Produto> {
        val listaProduto = mutableListOf<Produto>()

        val sql = "select * from produtos"
        val cursor = leitura.rawQuery(sql, null)


        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val descricao = cursor.getString(2)

            val produto = Produto(id, nome, descricao)
            listaProduto.add(produto)

        }
        return listaProduto
    }
}