package com.example.aula1510

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aula1510.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnExecutar.setOnClickListener {
            cadastrarUsuario()
        }
    }

    private fun cadastrarUsuario() {
        val email = "lu.faustino2000@gmail.com"
        val senha = "Luninhar@2014"

        val autenticacao = FirebaseAuth.getInstance()

        autenticacao.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener { authResult ->
                val id = authResult.user?.uid
                val email = authResult.user?.email

                binding.txtResultado.text = "Sucesso ao criar conta: $id - $email"
            }.addOnFailureListener { exception ->
                val mensagemErro = exception.message

                binding.txtResultado.text = "Erro ao criar conta: $mensagemErro"
            }
    }
}