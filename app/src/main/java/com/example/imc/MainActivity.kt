package com.example.imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var alturaEditText: EditText
    private lateinit var pesoEditText:EditText
    private lateinit var resultado:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.mainButton)
        alturaEditText = findViewById(R.id.alturatEditText)
        pesoEditText = findViewById(R.id.pesoEditText)
        resultado = findViewById(R.id.resultadoTextView)

        button.setOnClickListener{
            if (validarEntrada()) {
                val altura:Double = alturaEditText.text.toString().toDouble()
                val peso:Double = pesoEditText.text.toString().toDouble()

                val alturaM = altura / 100

                val imc = peso / (alturaM * alturaM)
                when{
                    imc < 18.5 -> resultado.text = getString(R.string.underweight)
                    imc in 18.5..24.9 -> resultado.text = getString(R.string.normal)
                    imc in 25.0..29.9 -> resultado.text = getString(R.string.overweight)
                    imc in 30.0..34.9 -> resultado.text = getString(R.string.obesityI)
                    imc in 35.0..39.9 -> resultado.text = getString(R.string.obesityII)
                    else-> resultado.text = getString(R.string.obesityIII
                    )
                }
            }
        }
    }

    private fun validarEntrada(): Boolean {
        if (alturaEditText.text.isEmpty() || pesoEditText.text.isEmpty()) {
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}