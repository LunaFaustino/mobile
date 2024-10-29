package com.example.aula1510

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        binding.btnAtualizar.setOnClickListener{
            atualizarInfo()
        }

        binding.btnRemover.setOnClickListener{
            removerInfo()
        }

        binding.btnListar.setOnClickListener{
            listarInfo()
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
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO AO SALVAR!")
                        .setMessage("Dados salvos com sucesso")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("ERRO AO SALVAR!")
                        .setMessage("Erro ao salvar dados")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()
                }
        }
    }

    private fun atualizarInfo(){

        val idUserAtual = autenticacao.currentUser?.uid

        if (idUserAtual != null){
            bancoDados
                .collection("usuarios")
                .document(idUserAtual)
                .update("telefone", binding.editTelefone.text.toString())
                .addOnSuccessListener {
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO AO ATUALIZAR!")
                        .setMessage("Dados atualizados com sucesso")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("ERRO AO ATUALIZAR!")
                        .setMessage("Erro ao atualizar dados")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()
                }
        }
    }

    private fun removerInfo(){
        val idUserAtual = autenticacao.currentUser?.uid

        if (idUserAtual != null){
            bancoDados
                .collection("usuarios")
                .document(idUserAtual)
                .delete()
                .addOnSuccessListener {
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO AO DELETAR!")
                        .setMessage("Dados deletados com sucesso")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()
                }
                .addOnFailureListener {
                    AlertDialog.Builder(this)
                        .setTitle("ERRO AO DELETAR!")
                        .setMessage("Erro ao deletar dados")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()
                }
        }
    }

    private fun listarInfo(){
        val idUserAtual = autenticacao.currentUser?.uid

        if (idUserAtual != null){
            bancoDados
                .collection("usuarios")
                .addSnapshotListener {querySnapshot,erro->
                    val docs = querySnapshot?.documents

                    var listaResultado = ""

                    docs?.forEach {documentoSnapshot->
                        val dados = documentoSnapshot.data

                        if (dados != null){
                            val nomeCompleto = dados["nomeCompleto"]
                            val telefone = dados["telefone"]

                            listaResultado += "Nome: $nomeCompleto - Telefone: $telefone \n"
                        }
                    }

                    binding.txtResultado.text = listaResultado
                }
        }
    }

//    private fun listarInfo(){
//        val idUserAtual = autenticacao.currentUser?.uid
//
//        if (idUserAtual != null){
//            bancoDados
//                .collection("usuarios")
//                .document(idUserAtual)
//                .addSnapshotListener {valor,erro->
//                    val dados = valor?.data
//
//                    if (dados != null){
//                        val nomeCompleto = dados["nomeCompleto"]
//                        val telefone = dados["telefone"]
//
//                        binding.txtResultado.text = "Nome: $nomeCompleto - Telefone: $telefone"
//                    }
//                }
//        }
//    }
}