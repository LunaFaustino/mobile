package com.example.cp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnProcurar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnProcurar = findViewById(R.id.btnProcurar)
        btnProcurar.setOnClickListener{
            val navegarProcurar = Intent(this, MainActivity2::class.java)
            startActivity(navegarProcurar)
        }


        }
    }