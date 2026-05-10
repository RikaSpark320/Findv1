package com.example.findv1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // El error probablemente estaba aquí. Debe ser activity_main
        setContentView(R.layout.activity_main)

        val btnFichas = findViewById<Button>(R.id.btnFichas)
        val btnReportes = findViewById<Button>(R.id.btnReportes)
        val btnEmergencia = findViewById<Button>(R.id.btnEmergencia)

        btnFichas.setOnClickListener {
            startActivity(Intent(this, SearchListActivity::class.java))
        }

        btnReportes.setOnClickListener {
            startActivity(Intent(this, ReportActivity::class.java))
        }

        btnEmergencia.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911")
            startActivity(intent)
        }
    }
}