package cl.viajes.sealed

sealed class EstadoReserva {
    object Pendiente: EstadoReserva()
    object Confirmando: EstadoReserva()
    object Emitido: EstadoReserva()

    data class Cancelado(val motivo: String) : EstadoReserva()

    fun manejoEstadoPasaje(estado: EstadoReserva) {
        when (estado) {
            is Pendiente -> println("Estado pendiente")
            is Confirmando -> println("Estado confirmado")
            is Emitido -> println("Estado de emitido")
            is Cancelado -> println("Estado de cancelado")
        }
    }
}