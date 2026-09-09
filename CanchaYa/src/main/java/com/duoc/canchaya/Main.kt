package com.duoc.canchaya

val canchaValida = mutableListOf<Cancha>()

fun main() {
    val datosEjemplo = listOf(
        CanchaFutbol("Cancha 1",18000.0,14),
        CanchaFutbol("Cancha 2",12000.0,10),
        CanchaPadel("Cancha 3",15000.0,true),
        CanchaPadel("Cancha 4",9000.0,false),
        CanchaFutbol("Cancha 5",-5000.0,10), // (dato inválido, para probar try-catch)
    )
    for (i in datosEjemplo) {
        try {
            if(i.valorHora > 0){
                canchaValida.add(i)
                println("Se registro exitosamente ${i.nombre}.")
            }else{
                throw IllegalArgumentException("valorHora no puede ser negativo")
            }
        } catch (e: IllegalArgumentException) {
            println("[ERROR AL AGREGAR CANCHA ${i.nombre}] --> ${e.message}")
        }
    }

    val listaDefinitiva: List<Cancha> = canchaValida
    println("\n== Resumen de canchas validas ==")
    for(i in listaDefinitiva) {
        println(i.nombre + " | $" + i.valorHora)
    }

    val canchasBaratas = listaDefinitiva.filter { it.valorHora <= 12000.0}.map { it.nombre }
    println("\n== Canchas con valorHora menor a 1200 ==")
    println(canchasBaratas)

    val totalEstimado = canchaValida.sumOf { i -> i.valorHora * 2 }
    println("\n == Ingreso total si se reservaran las canchas validas por 2 horas ==\n $totalEstimado")

    //

    //var estadoActual: EstadoReserva = EstadoReserva.Confirmando
    //var pagoAprobado = true

    //val mensajeFinal = when (estadoActual) {
    //    is EstadoReserva.Confirmando -> "El pedido sigue en preparacion."
    //    is EstadoReserva.Confirmada -> "Pedido en viaje con ${EstadoReserva.Confirmando}."
    //    is EstadoReserva.Rechazada -> "El pedido se cancelo: ${EstadoReserva.Rechazada.}."
    //}

}