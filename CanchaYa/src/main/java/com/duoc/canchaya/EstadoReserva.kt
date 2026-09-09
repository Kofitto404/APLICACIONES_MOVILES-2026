package com.duoc.canchaya

sealed class EstadoReserva {
    object Confirmando : EstadoReserva()
    data class Confirmada(val codigoReserva: String) : EstadoReserva()
    data class Rechazada(val motivo: String) : EstadoReserva()
}