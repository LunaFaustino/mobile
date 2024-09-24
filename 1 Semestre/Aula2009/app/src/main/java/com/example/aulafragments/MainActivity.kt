package com.example.aulafragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    private lateinit var btnCadastro:Button
    private lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnCadastro = findViewById(R.id.btnCadastro)

        btnCadastro.setOnClickListener{
            val cadastroFragment = CadastroFragment()

            val bundle = bundleOf(
                "nomeAluno" to "Luna",
                "numFaltas" to 0
            )
            cadastroFragment.arguments = bundle

            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,cadastroFragment).commit()
        }

        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,LoginFragment()).commit()
        }
    }
}