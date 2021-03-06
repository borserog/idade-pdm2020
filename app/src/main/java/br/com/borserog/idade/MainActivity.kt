package br.com.borserog.idade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalcular: Button
    private lateinit var inputNome: EditText
    private lateinit var inputAno: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btnCalcular)
        inputNome = findViewById(R.id.inputNome)
        inputAno = findViewById(R.id.inputAno)

        btnCalcular.setOnClickListener {
            onBtnCalcularClicked(it)
        }
    }

    private fun onBtnCalcularClicked(view: View?) {
        if (inputNome.text.isNullOrEmpty() && inputAno.text.isNullOrEmpty()) {
            val intent = Intent(this, ResultadoActivity::class.java)

            startActivity(intent)
            return
        }

        val pessoa = Pessoa(inputNome.text.toString(), inputAno.text.toString().toInt())


        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("MSG_PERSON_DATA", pessoa)

        startActivity(intent)
    }
}