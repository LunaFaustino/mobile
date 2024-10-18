package com.example.aula1510

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.aula1510.databinding.ActivityLogadoBinding
import com.google.firebase.auth.FirebaseAuth

class LogadoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLogadoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnDeslogar.setOnClickListener{
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}