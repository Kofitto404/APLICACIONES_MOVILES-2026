package com.example.comidaexpress

open class Producto(
    val nombre: String,
    val precioBase: Double
) {
    open fun calcularPrecioFinal(): Double {
        return precioBase
    }
}