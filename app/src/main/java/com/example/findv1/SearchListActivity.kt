package com.example.findv1
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        val rvFichas = findViewById<RecyclerView>(R.id.rvFichas)
        rvFichas.layoutManager = LinearLayoutManager(this)

        val datosPrueba = listOf(
            Persona("Juan Pérez", 35, "Visto por última vez en el centro.", R.mipmap.ic_launcher),
            Persona("María García", 28, "Llevaba sudadera roja.", R.mipmap.ic_launcher)
        )

        val adapter = FichaAdapter(datosPrueba) { personaSeleccionada ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("PERSONA_DATA", personaSeleccionada)
            startActivity(intent)
        }

        rvFichas.adapter = adapter
    }
}