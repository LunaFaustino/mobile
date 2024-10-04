package com.example.aula2709

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aula2709.bancodedados.DatabaseHelper
import com.example.aula2709.bancodedados.ProdutoDAO
import com.example.aula2709.model.Produto
import kotlin.Exception

class MainActivity : AppCompatActivity() {

    private val bancoDados by lazy {
        DatabaseHelper(this)
    }

    private lateinit var editNomeProduto:EditText
    private lateinit var btnSalvar:Button
    private lateinit var btnListar:Button
    private lateinit var btnAtualizar:Button
    private lateinit var btnDeletar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editNomeProduto = findViewById(R.id.editNomeProduto)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnListar = findViewById(R.id.btnListar)
        btnAtualizar = findViewById(R.id.btnAtualizar)
        btnDeletar = findViewById(R.id.btnDeletar)

        btnSalvar.setOnClickListener {
            salvar()
        }

        btnListar.setOnClickListener {
            listar()
        }

        btnAtualizar.setOnClickListener{
            atualizar()
        }

        btnDeletar.setOnClickListener {
            deletar()
        }

    }

    private fun salvar(){
        val nomeProduto = editNomeProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1,nomeProduto,"SEM DESCRIÇÃO"
        )

        produtoDAO.salvar(produto)
    }

    private fun listar(){
        val sql = "select * from produtos"
        val cursor = bancoDados.readableDatabase.rawQuery(sql,null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val descricao = cursor.getString(2)
            Log.i("db_info","ID: $id - Nome: $nome - Descrição: $descricao")

        }
    }

    private fun atualizar(){
        val nomeProduto = editNomeProduto.text.toString()
        val sql = "update produtos set titulo = '$nomeProduto' where id_produto = 2;"
        try {
            bancoDados.writableDatabase.execSQL(sql)
            Log.i("db_info","Nome do produto atualizado com sucesso.")
        }catch (e:Exception) {
            e.printStackTrace()
            Log.i("db_info", "Erro ao atualizar.")
        }
    }

    private fun deletar(){
        val sql = "delete from produtos where id_produto = 2;"
        try {
            bancoDados.writableDatabase.execSQL(sql)
            Log.i("db_info","Produto deletado com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Erro ao deletar.")
        }
    }
}