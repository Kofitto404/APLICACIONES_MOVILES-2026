package com.example.comidaexpress

import kotlin.compareTo

fun confirmarPago(monto: Double): Boolean {
    println("Procesando pago de $$monto...")
    Thread.sleep(800)
    return true
}

fun asignarRepartidor(): String {
    println("Asignando repartidor disponible...")
    Thread.sleep(800)
    return "Michi Mendoza (Moto #6767)"
}
val cliente = Cliente(
    nombre = "Camila Rojas",
    direccion = "Av. Siempre Viva 742, Santiago",
    true
)

val productosValidos = mutableListOf<Producto>()
val datosPrueba = listOf(
    Plato("Pastel de Choclo", 6500.0, "Grande"),
    Plato("Empanada de Pino", 1800.0, "Chica"),
    Bebida("Pisco Sour", 3200.0, true),
    Bebida("Mote con Huesillo", 1500.0, false),
    Plato("Ceviche", -2000.0, "Chica")
)
val listaDefinitiva: List<Producto> = productosValidos.also {
    println("\nSe registraron exitosamente ${it.size} productos en el pedido.")
}
val repartidorAsignado = asignarRepartidor()

// -----------------------------
// MAIN
// -----------------------------

fun main() {

    with(cliente) {
        println("=== DATOS DEL CLIENTE ===")
        println("Cliente: $nombre")
        println("Direccion: $direccion")
        println("Frecuente: $esClienteFrecuente")
        println("=========================")
    }

    for (i in datosPrueba) {
        try {
            productosValidos.add(i)
        } catch (e: IllegalArgumentException) {
            println("[ERROR AL AGREGAR PRODUCTO] ${e.message}")
        }
    }
    val bebidasAlcoholicas = listaDefinitiva
        .filter { it is Bebida && it.esAlcoholica }
        .map { it.nombre }

    println("Bebidas con alcohol identificadas: $bebidasAlcoholicas ")

    val subtotal = listaDefinitiva.sumOf { it.calcularPrecioFinal() }

    println("\nSubtotal: $$subtotal")

    val horaPedido = 23
    val recargoNocturno = if (horaPedido >= 22 || horaPedido < 6) 1000.0 else 0.0

    println("Recargo nocturno: $$recargoNocturno")

    val envioGratis = subtotal >= 15000.0 && cliente.esClienteFrecuente
    val costoEnvio = if (envioGratis) 0.0 else 2500.0

    println("Envio gratis aplicado: ${if (envioGratis) "Si" else "No (Costo: $$costoEnvio)"}")

    val totalFinal = subtotal + recargoNocturno + costoEnvio

    totalFinal.let {
        println("TOTAL CALCULADO: $$it")
    }

    println("\nTu pedido esta siendo preparado...")

    val resumen = ResumenPedido().apply {
        totalAPagar = totalFinal
    }
    var estadoActual: EstadoPedido = EstadoPedido.Preparando
    val pagoAprobado = confirmarPago(resumen.totalAPagar)

    estadoActual = if (pagoAprobado) {
        EstadoPedido.EnCamino(repartidorAsignado)
    } else {
        EstadoPedido.Cancelado("Transaccion bancaria rechazada")
    }



    val mensajeFinal = when (estadoActual) {
        is EstadoPedido.Preparando -> "El pedido sigue en preparacion."
        is EstadoPedido.EnCamino -> "Pedido en viaje con ${estadoActual.repartidor}."
        is EstadoPedido.Entregado -> "El pedido ya fue entregado."
        is EstadoPedido.Cancelado -> "El pedido se cancelo: ${estadoActual.motivo}."
    }

    println("\nEstado final: $mensajeFinal")
}