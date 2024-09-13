package com.example.aulaapi

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aulaapi.api.EnderecoAPI
import com.example.aulaapi.api.RetrofitHelper
import com.example.aulaapi.model.Endereco
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val retrofit by lazy{
        RetrofitHelper.retrofit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btnEnviar:Button = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                recuperarDados()
            }
        }
    }

    private suspend fun recuperarDados(){
        var retorno:Response<Endereco>? = null
        val cepDigitadoUsuario = "09991000"
        try {
            val enderecoAPI = retrofit.create(EnderecoAPI::class.java)
            retorno = enderecoAPI.recuperarEndereco(cepDigitadoUsuario)
        }catch (e:Exception){
            e.printStackTrace()
        }

        if (retorno != null){
            if (retorno.isSuccessful){
                var endereco = retorno.body()
                var rua = endereco?.logradouro
                var bairro = endereco?.bairro
                var cep = endereco?.cep

                Log.i("teste","RUA ${rua}")
            }
        }

    }
}