package com.example.tareas

// Creacion de la Clase Base Persona
open class Persona(
    val nombre: String,
    val edad: Int
) {
    open fun presentarse() {
        println("Hola, mi nombre es $nombre y tengo $edad años :3c.")
    }
}

// Implementacion de Herencia con la Clase Empleado

class Empleado(
    nombre: String,
    edad: Int,
    val puesto: String,
    private val salario: Double
) : Persona(nombre, edad) {

    fun mostrarPuesto() {
        println("$nombre trabaja como $puesto.")
    }

    override fun presentarse() {
        println("Hola!!!!, soy $nombre, tengo $edad años y mi puesto es $puesto >:3.")
    }
}

// Creacion de Objetos y Verificacion

fun main() {
    val persona1 = Persona("Redsy Mapache", 21)

    val empleado1 = Empleado("Kofi Wah", 19, "FullStack Developer", 2020207.67)

    println("--- Llama al metodo presentarse() en ambos objetos. ---")
    persona1.presentarse()
    empleado1.presentarse()
}

/*
Pregunta de reflexion
En un comentario en tu codigo, explica por que la misma llamada al metodo presentarse()
puede generar dos resultados distintos.
¿Que concepto de la POO se esta demostrando aqui? Argumenta con ejemplos

- Eeeeeeeee aunque el metodo presentarse() se llame igual tanto en la clase Persona como en la clase Empleado
  lo que permite generar 2 resultados distintos es el Override en el presentarse() de Empleado. Al usarse se puede
  sobreescribir dicho metodo para dar un resultado distinto.

- Un ejemplo de POO es esto mismo, el polimorfismo, cuando Persona usa su version de presentarse() llama a su version.
  Pero cuando Empleado hace lo mismo presentarse() devuelve un print distinto a pesar de ser el
  mismo metodo.

 */