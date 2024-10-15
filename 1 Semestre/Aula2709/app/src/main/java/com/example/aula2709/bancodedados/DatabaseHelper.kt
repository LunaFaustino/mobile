package com.example.aula2709.bancodedados

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class DatabaseHelper(contexto:Context): SQLiteOpenHelper(
    // context
    // nome do banco
    // CursorFactory
    // versão
    contexto,"loja",null,1

){
    companion object{
        const val TABELA = "produtos"
        const val ID_PRODUTO = "id_produto"
        const val TITULO = "titulo"
        const val DESCRICAO = "descricao"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        // é executado uma única vez, quando o app é instalado
        val sql = "CREATE TABLE IF NOT EXISTS $TABELA(" +
                "  $ID_PRODUTO integer not NULL PRIMARY KEY AUTOINCREMENT,"+
                "  $TITULO varchar(100),"+
                "  $DESCRICAO text"+
                ")"
        try {
            db?.execSQL(sql)
            Log.i("db_info","Tabela criada com sucesso!")
        } catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Erro ao criar tabela!")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // é executado sempre  que há mudança na versão do banco
    }
}