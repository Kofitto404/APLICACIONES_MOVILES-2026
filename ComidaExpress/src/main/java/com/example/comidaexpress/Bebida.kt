package com.example.comidaexpress

class Bebida(
    nombre: String,
    precioBase: Double,
    val esAlcoholica: Boolean
) : Producto(nombre, precioBase) {

    override fun calcularPrecioFinal(): Double {
        return if (esAlcoholica) {
            precioBase + 800.0
        }else{
            precioBase
        }
    }
}