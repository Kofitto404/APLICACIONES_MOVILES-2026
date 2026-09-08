package com.example.comidaexpress

class Plato(
    nombre : String,
    precio_base : Double,
    var tamano_Porcion : String
): Producto(nombre,precio_base){
    override fun calcularPrecioFinal() {
        if(tamano_Porcion.lowercase() == "grande"){
            precio_base * 0.25
        }else{
            precio_base
        }
    }
}