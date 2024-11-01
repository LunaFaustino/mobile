package com.example.aula1510

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.aula1510.databinding.ActivityUploadImagemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import java.util.UUID

class UploadImagemActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityUploadImagemBinding.inflate(layoutInflater)
    }

    private val autenticacao by lazy { FirebaseAuth.getInstance() }

    private val armazenamento by lazy {
        FirebaseStorage.getInstance()
    }

    private var uriImagemSelecionada:Uri? = null

    private val abrirGaleria = registerForActivityResult(
        ActivityResultContracts.GetContent())
        {uri ->
            if (uri!=null){
                binding.ImagemSelecionada.setImageURI(uri)
                uriImagemSelecionada = uri
                Toast.makeText(this, "Imagem selecionada", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Nenhuma imagem selecionada", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnGaleria.setOnClickListener{
            abrirGaleria.launch("image/*")
        }

        binding.btnUpload.setOnClickListener{
            uploadGaleria()
        }

        binding.btnPegarImagem.setOnClickListener{
            recuperarImagemFirebase()
        }

    }

    private fun uploadGaleria(){

        val idUsuarioLogado = autenticacao.currentUser?.uid
        val nomeImagem = UUID.randomUUID().toString()

        if (uriImagemSelecionada!=null && idUsuarioLogado!=null){
            armazenamento
                .getReference("fotos")
                .child(idUsuarioLogado)
                .child(nomeImagem)
                .putFile(uriImagemSelecionada!!)
                .addOnSuccessListener {
                    Toast.makeText(this,"Upload realizado com sucesso", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun recuperarImagemFirebase(){

        val idUsuarioLogado = autenticacao.currentUser?.uid

        if (idUsuarioLogado!=null){
            armazenamento
                .getReference("fotos")
                .child(idUsuarioLogado)
                .child("foto.jpg")
                .downloadUrl
                .addOnSuccessListener {uriFirebase->
                    Picasso.get()
                        .load(uriFirebase)
                        .into(binding.imgViewGet)
                }
        }
    }
}