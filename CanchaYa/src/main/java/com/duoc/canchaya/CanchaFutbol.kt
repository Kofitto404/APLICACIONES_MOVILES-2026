package com.duoc.canchaya

class CanchaFutbol(
    nombre: String,
    valorHora: Double,
    val cantidadJugadores: Int
) : Cancha(nombre, valorHora) {
    override fun calcularCostoReserva(horas: Int): Double {
        if (cantidadJugadores > 10) {
            return valorHora * 1.15
        } else {
            return valorHora
        }
    }
}