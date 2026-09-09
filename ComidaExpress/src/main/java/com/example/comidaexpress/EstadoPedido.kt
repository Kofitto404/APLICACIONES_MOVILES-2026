package com.example.comidaexpress

sealed class EstadoPedido {
    object Preparando : EstadoPedido()
    data class EnCamino(val repartidor: String) : EstadoPedido()
    object Entregado : EstadoPedido()
    data class Cancelado(val motivo: String) : EstadoPedido()
}