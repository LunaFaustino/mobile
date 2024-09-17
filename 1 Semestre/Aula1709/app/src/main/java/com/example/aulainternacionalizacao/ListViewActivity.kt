package com.example.aulainternacionalizacao

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity : AppCompatActivity() {

    private lateinit var listViewAlunos:ListView
    private lateinit var btnEnviar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        // chamada da visualização do spinner
        spinnerExibicao()

        listViewAlunos = findViewById(R.id.listViewFiap)

        val listaDeAlunos = listOf("Murillo","Luna","Atilla","William","Daniel","Glenda")

        listViewAlunos.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            listaDeAlunos
        )

        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener {
            spinnerSelecionado()
        }

    }

    private fun spinnerExibicao(){
        val estados = listOf("SP","RJ","MG","SC")
        var spinnerEstados:Spinner = findViewById(R.id.spinnerEstados)

        spinnerEstados.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            estados
        )
    }

    private fun spinnerSelecionado(){
        var spinnerEstados:Spinner = findViewById(R.id.spinnerEstados)

        var itemSelecionado = spinnerEstados.selectedItem
        var itemPosicao = spinnerEstados.selectedItemPosition

        var txtResultado:TextView = findViewById(R.id.txtResultado)
        txtResultado.text = "ITEM SELECIONADO ${itemSelecionado} - POSIÇÃO ${itemPosicao}"
    }
}