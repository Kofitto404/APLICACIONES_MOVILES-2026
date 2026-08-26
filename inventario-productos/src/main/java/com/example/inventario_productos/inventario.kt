package com.example.inventario_productos

fun main(){
    val producto1 = mapOf("nombre" to "Latte", "precio" to 2100, "categoria" to "Cafes")
    val producto2 = mapOf("nombre" to "Americano", "precio" to 1750, "categoria" to "Cafes")
    val producto3 = mapOf("nombre" to "Macchiato", "precio" to 3100, "categoria" to "Cafes")
    val producto4 = mapOf("nombre" to "Mendocino", "precio" to 1000, "categoria" to "Postres")
    val producto5 = mapOf("nombre" to "Medialuna", "precio" to 850, "categoria" to "Postres")
    val producto6 = mapOf("nombre" to "Aliado", "precio" to 1200, "categoria" to "Postres")

    val listaProductos = listOf(producto1, producto2, producto3, producto4, producto5, producto6)

    println("--- Menu cafeteria Siames ---")

    for (producto in listaProductos){
        val nombre = producto["nombre"]
        val precio = producto["precio"]
        val categoria = producto["categoria"]

        println("$categoria / $nombre --> $$precio")
    }
}
