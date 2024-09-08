package com.example.cp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    lateinit var btnVoltar: ImageButton
    lateinit var btnIntegrante: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        btnVoltar = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val navegarVoltar = Intent(this, MainActivity::class.java)
            startActivity(navegarVoltar)
        }

        btnIntegrante = findViewById(R.id.btnIntegrante)
        btnIntegrante.setOnClickListener {
            val navegarIntegrante = Intent(this, MainActivity3::class.java)
            startActivity(navegarIntegrante)
        }
    }
}