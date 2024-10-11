package com.example.aula2709

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AlertDialogLayout
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
    private lateinit var btnAlerta:Button

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
        btnAlerta = findViewById(R.id.btnAlerta)

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

        btnAlerta.setOnClickListener{
            caixaLogAlerta()
        }

    }

    private fun caixaLogAlerta(){
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirme a exclusão do item")
        alertBuilder.setMessage("Tem certeza que deseja remover?")

        alertBuilder.setNegativeButton("CANCELAR"){dialog,posicao->
            Toast.makeText(this,"Cancelando...",Toast.LENGTH_SHORT).show()
        }
        alertBuilder.setPositiveButton("CONFIRMAR"){dialog,posicao->
            Toast.makeText(this,"Excluindo...",Toast.LENGTH_SHORT).show()
        }

        alertBuilder.setCancelable(false)

        val alertDialog = alertBuilder.create()
        alertDialog.show()
    }

    private fun salvar(){
        val nomeProduto = editNomeProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1,nomeProduto,""
        )

        produtoDAO.salvar(produto)
    }

    private fun listar(){
        val produtoDAO = ProdutoDAO(this)
        val listaProdutos = produtoDAO.listar()

        if (listaProdutos.isNotEmpty()){
            listaProdutos.forEach{produto ->
                Log.i("db_info", "ID: ${produto.id} - Nome: ${produto.titulo} - Descrição: ${produto.descricao}")
            }
        }
    }

    private fun atualizar(){
        val nomeProduto = editNomeProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1,nomeProduto,""
        )

        produtoDAO.atualizar(produto)
    }

    private fun deletar(){

        val produtoDAO = ProdutoDAO(this)

        produtoDAO.remover(2)
    }
}