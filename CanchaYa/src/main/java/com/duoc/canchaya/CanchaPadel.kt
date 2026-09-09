package com.duoc.canchaya

class CanchaPadel(
    nombre: String,
    valorHora: Double,
    val techada: Boolean
) : Cancha(nombre, valorHora) {
    override fun calcularCostoReserva(horas: Int): Double {
        if (techada) {
            return valorHora + 3000.0
        } else {
            return valorHora
        }
    }
}