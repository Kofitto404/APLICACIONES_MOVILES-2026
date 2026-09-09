package com.duoc.canchaya

open class Cancha(
    val nombre: String,
    val valorHora: Double
) {
    open fun calcularCostoReserva(horas: Int): Double {
        return valorHora
    }
}