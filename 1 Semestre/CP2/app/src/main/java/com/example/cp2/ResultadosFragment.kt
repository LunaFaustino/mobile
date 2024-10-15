package com.example.cp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ResultadosFragment : Fragment() {

    private lateinit var txtNome: TextView
    private lateinit var txtCPF: TextView
    private lateinit var txtIdade: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtTel: TextView
    private lateinit var txtEstado: TextView
    private lateinit var btnVoltar: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resultados, container, false)

        txtNome = view.findViewById(R.id.txtNome)
        txtCPF = view.findViewById(R.id.txtCPF)
        txtIdade = view.findViewById(R.id.txtIdade)
        txtEmail = view.findViewById(R.id.txtEmail)
        txtTel = view.findViewById(R.id.txtTel)
        txtEstado = view.findViewById(R.id.txtEstado)
        btnVoltar = view.findViewById(R.id.btnVoltar)

        // Receber os dados do Bundle
        arguments?.let {
            txtNome.text = it.getString("nome")
            txtCPF.text = it.getString("cpf")
            txtIdade.text = it.getString("idade")
            txtEmail.text = it.getString("email")
            txtTel.text = it.getString("telefone")
            txtEstado.text = it.getString("estado")
        }

        btnVoltar.setOnClickListener {
            requireActivity().finish()
        }

        return view
    }
}