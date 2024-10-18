package com.example.aula1510

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aula1510.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val autenticacao by lazy { FirebaseAuth.getInstance() }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
        verificarUsuarioLogado()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnExecutar.setOnClickListener {
            cadastrarUsuario()
        }

        binding.btnLogin.setOnClickListener {
            logarUsuario()
        }

        binding.txtVEsqueceuSenha.setOnClickListener {
            esqueceuSenha()
        }

        binding.txtCadastrar.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

    private fun cadastrarUsuario() {
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

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

    private fun verificarUsuarioLogado() {
        val usuario = autenticacao.currentUser

        if (usuario != null){
            startActivity(Intent(this, LogadoActivity::class.java))
        }
    }

    private fun logarUsuario() {
        val email = binding.editEmail.text.toString()
        val senha =  binding.editSenha.text.toString()

        autenticacao.signInWithEmailAndPassword(email,senha)
            .addOnSuccessListener { authResult->
                startActivity(Intent(this, LogadoActivity::class.java))
            }
            .addOnFailureListener { exception->
                AlertDialog.Builder(this)
                    .setTitle("ERRO AO LOGAR!")
                    .setMessage("Verifica e-mail ou senha digitados")
                    .setPositiveButton("Fechar"){dialog, posicao->}
                    .create().show()
            }

    }

    private fun esqueceuSenha() {
        val email = binding.editEmail.text.toString()

        autenticacao.sendPasswordResetEmail(email)
    }
}