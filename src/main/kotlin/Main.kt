package cl.viajes

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

import cl.viajes.model.*
import cl.viajes.sealed.EstadoReserva
import java.lang.IO.readln

fun main() = runBlocking {

    val pasaje1 = PasajeAereo(
        origen = "Santiago",
        destino = "Tokio",
        precioBase = 2000000,
        ejecutiva = false,
    )

    val pasaje2 = PasajeTerrestre(
        origen = "Santiago",
        destino = "Puero Varas",
        precioBase = 10000,
        vip = true
    )

    val nombre = readln("Ingresa nombre del cliente:\n")

    val opcionCategoriaCliente = readln("""
        Selecciona la categoria del cliente:
        1.- Regular
        2.- Frecuente
        3.- Premium
    """.trimIndent()).toInt()

    val categoria = when(opcionCategoriaCliente) {
        1 -> CategoriaCliente.REGLUAR
        2 -> CategoriaCliente.FRECUENTE
        3 -> CategoriaCliente.PREMIUM
        else -> "Opcion no valida"
    }

    val cliente = Cliente (nombre, categoria)
    val listaPasajes = mutableListOf<Pasaje>()
    var opcion = 0

    while (opcion != 3) {
        opcion = readln("""
            === Travel Fast ===
            1.- Santiago - Tokio
            2.- Santiago - Puerto Varas
            3.- Terminar Compra
            
            Selecciona una opcion: 
        """.trimIndent()).toInt()

        when (opcion) {
            1 -> {listaPasajes.add(pasaje1)
            println("Pasaje Agregado")}
            2 -> {listaPasajes.add(pasaje2)
            println("Pasaje Agregado")}
            3 -> {
                println("Finalizando Compra...")
            } else -> {
                println("Opcion no valida")
            }
        }
    }

    val reserva = Reserva(cliente, listaPasajes)

    println("""
        --- Detalle de reserva ---
        Cliente: ${cliente.nombre}
        Categoria: ${cliente.categoriaCliente}
        
        Pasajes:
    """.trimIndent())
    listaPasajes.forEach {println("${it.origen} - ${it.destino} - ${it.calcularPrecioFinal()}")}

    println("""
        SubTotal: ${reserva.subTotal()}
        Descuento: ${reserva.descuento()}
        Cargos Administrativos: ${reserva.cargoAdministrativos()}
        Impuestos: ${reserva.impuesto()}
        Total: ${reserva.total()}
    """.trimIndent())
    procesarReserva(reserva)
}

suspend fun procesarReserva(reserva: Reserva) {

    val pendiente = EstadoReserva.Pendiente
    pendiente.manejoEstadoPasaje(estado = pendiente)
    delay(3000)

    val confirmando = EstadoReserva.Confirmador
    confirmando.manejoEstadoPasaje(estado = confirmando)

    delay(3000)

    val emitido = EstadoReserva.Emitido
    emitido.manejoEstadoPasaje(estado = emitido)
}