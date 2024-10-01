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
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val bancoDados by lazy {
        DatabaseHelper(this)
    }

    private lateinit var editNomeProduto:EditText
    private lateinit var btnSalvar:Button
    private lateinit var btnListar:Button

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

        btnSalvar.setOnClickListener {
            salvar()
        }

        btnListar.setOnClickListener {
            listar()
        }

    }

    private fun salvar(){
        val nomeProduto = editNomeProduto.text.toString()
        try {
            bancoDados.writableDatabase.execSQL("insert into produtos values(null, '$nomeProduto', '120GB')")
            Log.i("db_info","Produto inserido com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun listar(){
        val sql = "select * from produtos"
        val cursor = bancoDados.readableDatabase.rawQuery(sql,null)

        while (cursor.moveToNext()){
            val nome = cursor.getString(1)
            val descricao = cursor.getString(2)
            Log.i("db_info","Nome: $nome Descrição: $descricao")

        }
    }
}