package com.duoc.formativas.nro1

class EntradaGeneral(
    id : Int,
    evento : String,
    asistente : String,
    fecha : String,
    lugar : String,
    precio : Double
): Entrada(id, evento, asistente, fecha, lugar, precio){
    override fun mostrarDetalle() {
        println("--- ENTRADA GENERAL $id ---")
        println("$evento / $fecha")
        println("- $asistente")
        println("- $lugar")
        println("- $precio$ USD")
        println()
    }
}