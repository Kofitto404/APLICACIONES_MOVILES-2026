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
        return "Soy $nombre, tengo ${edad}y"
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
): Persona(nombre,rut,dv, fechaNacimiento, edad){
    fun calcularBonificacion() : Double{
        return sueldo * 0.1
    }
}


fun main(){
    val persona1 = Persona("Kofi",11222333,4,"20/09/2006",19)
    val persona2 = Persona("Redsy",11222333,4,"15/06/2006",21)
    val persona3 = Persona("Live",11222333,4,"18/06/2006",24)

    println("--- Paso 1 Clases y Objetos")

    println(persona1.mostrarInfo())
    println(persona2.mostrarInfo())
    println(persona3.mostrarInfo())



    println("--- Paso 2 Crear un objeto")

    val empleado = Empleado(
        nombre = "Macu",
        rut = 12345678,
        dv = 9,
        fechaNacimiento = "24/12/2067",
        edad = 5,
        cargo = "Gato waton y flojo",
        sueldo = 12.00
    )

    println(empleado.mostrarInfo())

    println("--- Paso 3 Herencia")
    print(empleado.mostrarInfo())
    println("| Bonificacion: ${empleado.calcularBonificacion()}")
    println("| Cargo: ${empleado.cargo}")

    val listaInformable: List<Informable> = listOf(persona1, persona2, persona3, empleado)

    println("--- Paso 4 Polimorfismo")

    for(item in listaInformable){
        println(item.informar())
    }

}