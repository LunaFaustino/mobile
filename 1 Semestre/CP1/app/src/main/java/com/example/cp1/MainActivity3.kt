package com.example.cp1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    lateinit var tela: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        tela = findViewById(R.id.main)
        tela.setOnClickListener{
            val navegarInicio = Intent(this, MainActivity::class.java)
            startActivity(navegarInicio)
        }
    }


}