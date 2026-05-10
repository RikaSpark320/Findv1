package com.example.findv1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val btnSeleccionarHora = findViewById<Button>(R.id.btnSeleccionarHora)
        val tvFechaHoraSeleccionada = findViewById<TextView>(R.id.tvFechaHoraSeleccionada)
        val btnTomarFoto = findViewById<Button>(R.id.btnTomarFoto)
        val btnEnviarReporte = findViewById<Button>(R.id.btnEnviarReporte)

        btnSeleccionarHora.setOnClickListener {
            mostrarSelectorFechaHora(tvFechaHoraSeleccionada)
        }

        btnTomarFoto.setOnClickListener {
            Toast.makeText(this, "Función de cámara pendiente", Toast.LENGTH_SHORT).show()
        }

        btnEnviarReporte.setOnClickListener {
            Toast.makeText(this, "Reporte enviado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun mostrarSelectorFechaHora(textView: TextView) {
        val calendario = Calendar.getInstance()

        DatePickerDialog(this, { _, year, month, day ->
            TimePickerDialog(this, { _, hour, minute ->
                val fechaHora = "$day/${month + 1}/$year $hour:$minute"
                textView.text = fechaHora
            }, calendario.get(Calendar.HOUR_OF_DAY), calendario.get(Calendar.MINUTE), true).show()
        }, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show()
    }
}