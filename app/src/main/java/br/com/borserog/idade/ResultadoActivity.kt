package br.com.borserog.idade

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textResult = findViewById(R.id.textResult)

        val pessoa = intent.getParcelableExtra<Pessoa>("MSG_PERSON_DATA")

        val formatText = when {
            pessoa != null -> getString(R.string.exibir_resultado, pessoa.nome, pessoa.idade())
            else -> getString(R.string.resultado_erro)
        }

        textResult.text = formatText

        textResult.setOnClickListener { onTextTouched(it) }
    }

    private fun onTextTouched(view: View?) {
        val localIntent = Intent()
        localIntent.putExtra("MSG_BACK", "Returning to main page")
        finish()
    }
}