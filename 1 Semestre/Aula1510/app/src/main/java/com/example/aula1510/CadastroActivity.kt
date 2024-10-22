package com.example.aula1510

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aula1510.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth

class CadastroActivity : AppCompatActivity() {

    private val autenticacao by lazy { FirebaseAuth.getInstance() }

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener {
            cadastrarUsuario()
        }

    }

    private fun cadastrarUsuario() {
        val email = binding.editEmail2.text.toString()
        val senha = binding.editSenha2.text.toString()

        autenticacao.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener { authResult ->
                val email = authResult.user?.email

                AlertDialog.Builder(this)
                    .setTitle("SUCESSO AO CADASTRAR!")
                    .setMessage("Conta criada com o e-mail $email")
                    .setPositiveButton("Fechar") { dialog, _ ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    .setCancelable(false).create().show()

            }.addOnFailureListener { exception ->
                val mensagemErro = exception.message

                AlertDialog.Builder(this)
                    .setTitle("ERRO AO CADASTRAR!")
                    .setMessage("Erro ao criar conta: $mensagemErro")
                    .setPositiveButton("Fechar"){dialog, posicao->}
                    .create().show()
            }
    }
}