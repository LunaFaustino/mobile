package com.example.cp2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class FormularioFragment : Fragment() {

    private lateinit var editNome:EditText
    private lateinit var editCPF:EditText
    private lateinit var editIdade:EditText
    private lateinit var editEmail:EditText
    private lateinit var editTel:EditText
    private lateinit var spinnerEstados: Spinner
    private lateinit var btnEnviar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_formulario, container, false)

        editNome = view.findViewById(R.id.editNome)
        editCPF = view.findViewById(R.id.editCPF)
        editIdade = view.findViewById(R.id.editIdade)
        editEmail = view.findViewById(R.id.editEmail)
        editTel = view.findViewById(R.id.editTel)
        btnEnviar = view.findViewById(R.id.btnEnviar)
        spinnerEstados = view.findViewById(R.id.spinnerEstados)

        val estados = resources.getStringArray(R.array.estados_brasileiros)
        spinnerEstados.adapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_dropdown_item,
            estados
        )

        // Quando clicar no botão "Enviar", iniciar a TelaResultadosActivity com os dados
        btnEnviar.setOnClickListener {
            val nome = editNome.text.toString()
            val cpf = editCPF.text.toString()
            val idade = editIdade.text.toString()
            val email = editEmail.text.toString()
            val telefone = editTel.text.toString()
            val estado = spinnerEstados.selectedItem.toString()

            // Criar uma Intent para iniciar a TelaResultadosActivity e passar os dados
            val intent = Intent(requireContext(), TelaResultadosActivity::class.java).apply {
                putExtra("nome", nome)
                putExtra("cpf", cpf)
                putExtra("idade", idade)
                putExtra("email", email)
                putExtra("telefone", telefone)
                putExtra("estado", estado)
            }

            // Iniciar a TelaResultadosActivity
            startActivity(intent)
        }

        return view
    }

}