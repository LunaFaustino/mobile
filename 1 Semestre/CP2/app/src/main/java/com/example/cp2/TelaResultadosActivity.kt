package com.example.cp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tela_resultados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obter os dados da Intent
        val nome = intent.getStringExtra("nome")
        val cpf = intent.getStringExtra("cpf")
        val idade = intent.getStringExtra("idade")
        val email = intent.getStringExtra("email")
        val telefone = intent.getStringExtra("telefone")
        val estado = intent.getStringExtra("estado")

        // Criar um Bundle para passar os dados para o ResultadosFragment
        val bundle = Bundle().apply {
            putString("nome", nome)
            putString("cpf", cpf)
            putString("idade", idade)
            putString("email", email)
            putString("telefone", telefone)
            putString("estado", estado)
        }

        // Iniciar o ResultadosFragment com os dados
        val resultadosFragment = ResultadosFragment().apply {
            arguments = bundle
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, resultadosFragment)
            .commit()
    }
}