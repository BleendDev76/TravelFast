package cl.viajes.model

open class Pasaje (
    var origen: String,
    var destino: String,
    var precioBase: Int,
) {
    open fun calcularPrecioFinal(): Int {
        return precioBase
    }

    override fun toString(): String {
        return ("Pasaje {origen $origen, destino $destino, precioBase $precioBase}")
    }
}