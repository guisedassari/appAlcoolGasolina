package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var valorGasolina = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasolina = findViewById<TextView>(R.id.txtValorGasolina)
        var txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        seekBar.max = 1000

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valorGasolina = progress
                txtGasolina.text = "R$ ${formataValor(valorGasolina / 100.0)}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Selecione o valor da gasolina."
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Clique em calcular para saber o resultado."
            }

        })

        btnCalcular.setOnClickListener {
            var valorResultado = (valorGasolina * 0.7) / 100.0
            txtResultado.text = "Abasteça com Alcool se ele curtar até: R$ ${formataValor(valorResultado)}"
        }
    }

    private fun formataValor(valor: Double): Any? {
        return String.format(Locale.FRANCE, "%.2f", valor)
    }
}
