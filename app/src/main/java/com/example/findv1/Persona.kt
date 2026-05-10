package com.example.findv1

import java.io.Serializable

data class Persona(
    val nombre: String,
    val edad: Int,
    val descripcion: String,
    val imagenResId: Int
) : Serializable