package com.example.inventario_productos

interface Informable {
    fun informar() : String
}

open class Persona(
    val nombre: String,
    val rut: Int,
    val dv: Int,
    val fechaNacimiento: String,
    val edad: Int
) : Informable {
    open fun mostrarInfo(): String {
        return "Nombre: $nombre | Rut: $rut-$dv | Fecha de nacimiento: $fechaNacimiento"
    }
    override fun informar(): String{
        return "Soy $nombre, tengo $edad años"
    }
}

class Empleado(
    nombre: String,
    rut: Int,
    dv: Int,
    fechaNacimiento: String,
    edad: Int,
    val cargo: String,
    val sueldo: Double
): Persona(nombre,rut,dv, fechaNacimiento, edad)

fun main(){
}