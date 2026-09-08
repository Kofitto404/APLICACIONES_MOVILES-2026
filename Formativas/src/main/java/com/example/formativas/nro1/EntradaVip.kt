package com.duoc.formativas.nro1

class EntradaVip(
    id : Int,
    evento : String,
    asistente : String,
    fecha : String,
    lugar : String,
    precio : Double,
    val descuentoExtra : Double
): Entrada(id, evento, asistente, fecha, lugar, precio){
    override fun mostrarDetalle() {
        println("--- !!!ENTRADA VIP!!! $id ---")
        println("$evento VIP / $fecha")
        println("- $asistente | VIP")
        println("- $lugar | ACCESO ZONA VIP")
        println("- $precio$ USD")
        println("- $descuentoExtra%OFF en MERCH y COMIDA")
        println()
    }
}