package com.example.findv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FichaAdapter(
    private val listaPersonas: List<Persona>,
    private val onClick: (Persona) -> Unit
) : RecyclerView.Adapter<FichaAdapter.FichaViewHolder>() {

    class FichaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFoto: ImageView = view.findViewById(R.id.ivFoto)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvEdad: TextView = view.findViewById(R.id.tvEdad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FichaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ficha, parent, false)
        return FichaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FichaViewHolder, position: Int) {
        val persona = listaPersonas[position]
        holder.tvNombre.text = persona.nombre
        holder.tvEdad.text = "Edad: ${persona.edad} años"
        holder.ivFoto.setImageResource(persona.imagenResId)

        holder.itemView.setOnClickListener {
            onClick(persona)
        }
    }

    override fun getItemCount() = listaPersonas.size
}