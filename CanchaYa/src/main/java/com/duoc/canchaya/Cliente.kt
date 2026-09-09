package com.duoc.canchaya
import com.duoc.canchaya.Cancha

open class Cliente (
    val nombre : String,
    val esSocio: Boolean,
    val horaReserva : Int
)

// TODO   Ademas, si la hora de inicio de la reserva esta entre las 19 y las 22 horas (inclusive), se aplica un recargo de
// TODO   $2.000 por hora, independiente de si hay descuento por socio
