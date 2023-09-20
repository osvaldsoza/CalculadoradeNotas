package br.com.osvaldsoza.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.osvaldsoza.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntCalcular.setOnClickListener {
            calcular()
        }

    }

    private fun calcular() {
        val nota1 = if(binding.edtNota1.text.isEmpty()) 0 else binding.edtNota1.text.toString().toInt()
        val nota2 = if(binding.edtNota2.text.isEmpty()) 0 else binding.edtNota2.text.toString().toInt()
        val nota3 = if(binding.edtNota3.text.isEmpty()) 0 else binding.edtNota3.text.toString().toInt()
        val nota4 = if(binding.edtNota4.text.isEmpty()) 0 else binding.edtNota4.text.toString().toInt()
        val numeroFaltas = if(binding.edtFaltas.text.isEmpty()) 0 else binding.edtFaltas.text.toString().toInt()

        val resultado = binding.txtResultado

        val mediaAluno = (nota1 + nota2 + nota3 + nota4) / 4

        if (mediaAluno >= 5 && numeroFaltas <= 20) {
            resultado.setText("Aluno foi Aprovado! \n Média final: $mediaAluno")
            resultado.setTextColor(getColor(R.color.green))
        } else if (numeroFaltas > 20) {
            resultado.setText("Aluno foi Reprovado por falta! \n Média final: $mediaAluno")
            resultado.setTextColor(getColor(R.color.red))
        } else if (mediaAluno < 5) {
            resultado.setText("Aluno foi Reprovado! \n Média final: $mediaAluno")
            resultado.setTextColor(getColor(R.color.red))
        }
    }
}