package com.example.aula3008

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrirCadastro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonAbrirCadastro = findViewById(R.id.btnCadastro)
        buttonAbrirCadastro.setOnClickListener{
            val navegarCadastro = Intent(this, TelaCadastro::class.java)
            startActivity(navegarCadastro)
        }
    }

    fun sortear(view:View){
        val textoResultado = findViewById<TextView>(R.id.txtViewResultado)
        val numeroAleatorio = Random.nextInt(20)
        textoResultado.setText("Número aleatório: ${numeroAleatorio}")
    }


}