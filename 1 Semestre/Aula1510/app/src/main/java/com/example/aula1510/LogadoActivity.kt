package com.example.aula1510

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.aula1510.databinding.ActivityLogadoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LogadoActivity : AppCompatActivity() {

    private val autenticacao by lazy { FirebaseAuth.getInstance() }

    private val binding by lazy {
        ActivityLogadoBinding.inflate(layoutInflater)
    }

    private val bancoDados by lazy {
        FirebaseFirestore.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnDeslogar.setOnClickListener{
            autenticacao.signOut()

            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnSalvar.setOnClickListener{
            salvarInfo()
        }


    }

    private fun salvarInfo() {
        val dados = mapOf(
            "nomeCompleto" to binding.edtNmCompleto.text.toString(),
            "telefone" to binding.editTelefone.text.toString()
        )

        val idUserAtual = autenticacao.currentUser?.uid

        if (idUserAtual != null){
            bancoDados
                .collection("usuarios")
                .document(idUserAtual)
                .set(dados)
                .addOnSuccessListener {
                    Log.i("db_info", "Dados salvos com sucesso!")
                }
                .addOnFailureListener {
                    Log.i("db_info", "Erro ao salvar dados!")
                }
        }




    }
}