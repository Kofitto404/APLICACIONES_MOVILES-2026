package com.example.comidaexpress

class Plato(
    nombre: String,
    precioBase: Double,
    val tamanoPorcion: String
) : Producto(nombre, precioBase) {

    override fun calcularPrecioFinal(): Double {
        return if (tamanoPorcion.lowercase() == "grande") {
            precioBase * 1.25
        } else {
            precioBase
        }
    }
}