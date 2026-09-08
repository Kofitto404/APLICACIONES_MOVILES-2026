package com.example.comidaexpress

class Bebida(
    nombre: String,
    precio_base: Double,
    var es_alcoholica: Boolean
) : Producto(nombre,precio_base){
    override fun calcularPrecioFinal() {
        if(es_alcoholica){
            precio_base + 800
        }else{
            precio_base
        }
    }
}