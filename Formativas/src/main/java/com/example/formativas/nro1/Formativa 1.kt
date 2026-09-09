package com.duoc.formativas.nro1

open class Entrada(
    val id : Int,
    val evento : String,
    val asistente : String,
    val fecha : String,
    val lugar : String,
    val precio : Double
) {
    open fun mostrarDetalle() {
        println("--- ENTRADA $id ---")
        println("$evento ---> $fecha")
        println("- $asistente")
        println("- $lugar")
        println("- $precio USD")
    }
}

var listaEntradas = mutableListOf<Entrada>()

var totalVentas : Double = 0.0
var totalEntradasVip : Int = 0

fun main() {

    val entradaGeneral1 = EntradaGeneral(1, "SAFE 2027", "Kofi Wah", "25-02-2027 -> 28-05-2027", "Hotel Almacruz", 90.0)
    listaEntradas.add(entradaGeneral1)
    val entradaGeneral2 = EntradaGeneral(2, "SAFE 2027", "Redsy Raccoon", "25-02-2027 -> 28-05-2027 ", "Hotel Almacruz", 90.0)
    listaEntradas.add(entradaGeneral2)
    val entradaVip1 = EntradaVip(3, "SAFE 2027", "Livelyapio", "24-02-2027 -> 28-05-2027", "Hotel Almacruz", 120.0, 6.7)
    listaEntradas.add(entradaVip1)

    println("--- Llama al metodo mostrarDetalle() en ambos objetos. ---")
    for (item in listaEntradas){
        item.mostrarDetalle()

        totalVentas += item.precio
        if(item is EntradaVip){
            totalEntradasVip ++
        }

    }

    println("\nTotal acumulado: $$totalVentas USD")
    println("\nEntradas VIP: $totalEntradasVip")
}
