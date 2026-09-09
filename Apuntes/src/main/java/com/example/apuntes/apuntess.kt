package com.example.apuntes

// -----------------------------------------------------------------------------
// 1. CREAR CLASES
// -----------------------------------------------------------------------------

// Para que otras clases puedan heredar de otras hay que marcarlas con open

open class Campeon(
    val nombre: String,
    val vidaBase: Int,
    val ataqueBase: Int
) {
    open fun infligirDanio(): Int {
        return ataqueBase
    }
}

// -----------------------------------------------------------------------------
// 1.1 SEALED CLASS
// -----------------------------------------------------------------------------

sealed class EstadoPartida {
    object SeleccionCampeon : EstadoPartida()
    data class EnJuego(val minuto: Int, val dragonesObtenidos: Int) : EstadoPartida()
    data class Victoria(val mvp: String) : EstadoPartida()
    data class Derrota(val causa: String) : EstadoPartida()
}
class ResumenInvocador {
    var campeonPrincipal: String = ""
    var oroFinal: Int = 0
}

// -----------------------------------------------------------------------------
// 2. CLASE HIJA (Herencia y Polimorfismo)
// -----------------------------------------------------------------------------
// : para heredar

class YordleTeemo(
    nombre: String,
    vidaBase: Int,
    ataqueBase: Int,
    val venenoPorSegundo: Int
) : Campeon(nombre, vidaBase, ataqueBase) {

    // Digamos que teemo suma el danio de su veneno al ataque base xd
    override fun infligirDanio(): Int {
        return ataqueBase + (venenoPorSegundo * 3)
    }
}

class YordleGnar(
    nombre: String,
    vidaBase: Int,
    ataqueBase: Int,
    val furia: Int
) : Campeon(nombre, vidaBase, ataqueBase) {

    // Si gnar tiene 100 de furia se transforma y pega el doble
    override fun infligirDanio(): Int {
        return if (furia >= 100) ataqueBase * 2 else ataqueBase
    }
}

// -----------------------------------------------------------------------------
// MAIN
// -----------------------------------------------------------------------------

fun main() {

    println("==================================================")
    println("1 y 2. DEMOSTRACIoN DE CLASES Y HERENCIA")
    println("==================================================")
    val teemo = YordleTeemo(nombre = "Teemo", vidaBase = 540, ataqueBase = 54, venenoPorSegundo = 20)
    val gnar = YordleGnar(nombre = "Gnar", vidaBase = 510, ataqueBase = 57, furia = 100)
    val kled = Campeon(nombre = "Kled", vidaBase = 410, ataqueBase = 65)

    println("${teemo.nombre} inflige: ${teemo.infligirDanio()} de danio total.")
    println("${gnar.nombre} (Mega Gnar) inflige: ${gnar.infligirDanio()} de danio total.")
    println("${kled.nombre} inflige: ${kled.infligirDanio()} de danio basico.")


    println("\n==================================================")
    println("3. CONDICIONALES Y BUCLES: IF, WHEN, WHILE, FOR")
    println("==================================================")

    // IF
    val vidaActual = 150
    val alerta = if (vidaActual < 200) "Te estas por morir" else "Vas bien."
    println("Alerta de vida: $alerta")

    // WHEN
    val rol = "Top"
    when (rol) {
        "Top" -> println("Linea superior: Teemo, Gnar o Kled.")
        "Mid" -> println("Linea media: Magos o Asesinos.")
        "Bot" -> println("Linea inferior: Tirador con soporte.")
        else -> println("Jungla o rol no especificado.")
    }

    // FOR
    print("Contador de hongos plantados por Teemo: ")
    for (hongo in 1..4) {
        print("[$hongo] ")
    }
    println()

    // WHILE
    var acumulacionesKraken = 0
    while (acumulacionesKraken < 3) {
        acumulacionesKraken++
        println("Cargando Mata-krakens... Cargas: $acumulacionesKraken/3")
    }
    println("Tercer golpe Danio verdadero.")


    println("\n==================================================")
    println("4. COLECCIONES: List Y MapOf")
    println("==================================================")

    // listOf y mutableListOf
    val inventarioTeemo = listOf("Mata-krakens", "Diente de Nashor", "Sombrero de Rabadon", "Botas de Hechicero")
    println("Primer item del inventario: ${inventarioTeemo[0]}")

    // Map: par clave -> valor
    val preciosTienda = mapOf(
        "Mata-krakens" to 3100,
        "Diente de Nashor" to 3000,
        "Sombrero de Rabadon" to 3600,
        "Pocion de vida" to 50
    )
    println("Costo de Rabadon: ${preciosTienda["Sombrero de Rabadon"]} de oro.")


    println("\n==================================================")
    println("5. FILTROS EN COLECCIONES (filter, map)")
    println("==================================================")

    // filtro
    val itemsCaros = preciosTienda.filter { it.value >= 3000 }
    println("Items de mas de 3000 de oro: $itemsCaros")

    // map: transforma una lista de un tipo/forma a otro
    val nombresItemsEnMayusculas = inventarioTeemo.map { it.uppercase() }
    println("Items en mayusculas: $nombresItemsEnMayusculas")


    println("\n==================================================")
    println("6. sumOf Y AGRERGAR PARECIDOS")
    println("==================================================")

    // sumOf: suma el valor total de los elementos
    val oroTotalInventario = inventarioTeemo.sumOf { item ->
        preciosTienda[item] ?: 0
    }
    println("Valor neto total de la build: $oroTotalInventario de oro.")

    // Otros mrtodos utiles
    val preciosSoloNumeros = listOf(3100, 3000, 3600, 50)
    println("Item mas costoso (maxOrNull): ${preciosSoloNumeros.maxOrNull()}")
    println("Item mas barato (minOrNull): ${preciosSoloNumeros.minOrNull()}")
    println("Promedio de costo (average): ${preciosSoloNumeros.average()}")
    println("Cantidad de items legendarios (count): ${preciosSoloNumeros.count { it >= 3000 }}")


    println("\n==================================================")
    println("7. SCOPE also, with, let, apply, run")
    println("==================================================")

    // apply -> Altera un objeto
    val resumen = ResumenInvocador().apply {
        campeonPrincipal = "Kled"
        oroFinal = oroTotalInventario
    }
    println("Resumen configurado con apply: ${resumen.campeonPrincipal} con ${resumen.oroFinal} de oro.")

    // also -> Ejecuta acciones secundarias
    val campeonesElegidos = mutableListOf("Teemo", "Gnar").also { lista ->
        println("Log con also: Inicializada la lista con ${lista.size} campeones.")
    }
    campeonesElegidos.add("Kled")

    // let -> Se usa para transformar variables o verificar que no sean nulas
    val mvpPotencial: String? = "Kled el Jinete Cantarida"
    mvpPotencial?.let { nombre ->
        println("Resultado con let: El MVP destacado de la partida es: $nombre")
    }

    // with -> Accede directamente a las propiedades de un objeto existente sin repetir su nombre
    with(teemo) {
        println("Ficha tecnica con with: Nombre: $nombre | Vida: $vidaBase | AD: $ataqueBase")
    }

    // run ->
    val descripcionGnar = gnar.run {
        "Descripcion con run: $nombre tiene $vidaBase de vida y esta listo para la tf."
    }
    println(descripcionGnar)


    println("\n==================================================")
    println("8. MANEJO DE ESTADOS CON SEALED CLASS + WHEN")
    println("==================================================")


    val estado: EstadoPartida = EstadoPartida.EnJuego(minuto = 25, dragonesObtenidos = 3)

    when (estado) {
        is EstadoPartida.SeleccionCampeon -> {
            println("Fase de seleccion: Teemo = wekito.")
        }
        is EstadoPartida.EnJuego -> {
            println("Partida en curso al minuto ${estado.minuto}. Dragones conseguidos: ${estado.dragonesObtenidos}.")
        }
        is EstadoPartida.Victoria -> {
            println("GGEZ! MVP: ${estado.mvp}.")
        }
        is EstadoPartida.Derrota -> {
            println("Derrota :( Motivo: ${estado.causa}.") // pe causa
        }
    }


    println("\n==================================================")
    println("9. MANEJO DE ERRORES")
    println("==================================================")

    // Lista de nivel de maestria de campeones a validar (debe estar entre 1 y 9)
    val listaMaestriasParaValidar = listOf(7, 4, 12, 0, -3, 9)

    for (maestria in listaMaestriasParaValidar) {
        try {
            // Validacion con IF: el numero debe ser mayor a 0 y menor a 10
            if (maestria <= 0 || maestria >= 10) {
                throw IllegalArgumentException("La maestria $maestria es invalida. Debe ser mayor a 0 y menor a 10.")
            }
            println("Maestria de campeon valida procesada: $maestria")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}