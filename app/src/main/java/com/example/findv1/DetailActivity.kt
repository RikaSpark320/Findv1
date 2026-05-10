package com.example.findv1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ivDetailFoto = findViewById<ImageView>(R.id.ivDetailFoto)
        val tvDetailNombre = findViewById<TextView>(R.id.tvDetailNombre)
        val tvDetailEdad = findViewById<TextView>(R.id.tvDetailEdad)
        val tvDetailDescripcion = findViewById<TextView>(R.id.tvDetailDescripcion)

        val persona = intent.getSerializableExtra("PERSONA_DATA") as? Persona

        persona?.let {
            tvDetailNombre.text = it.nombre
            tvDetailEdad.text = "Edad: ${it.edad} años"
            tvDetailDescripcion.text = it.descripcion
            ivDetailFoto.setImageResource(it.imagenResId)
        }
    }
}