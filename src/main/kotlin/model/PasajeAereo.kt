package cl.viajes.model

class PasajeAereo (origen: String, destino: String, precioBase: Int, var ejecutiva: Boolean) : Pasaje(origen, destino, precioBase) {
    override fun calcularPrecioFinal(): Int {

        var valor = precioBase
        if(ejecutiva) {
            valor += 50000
        }
        return valor
    }

    override fun toString(): String {
        return super.toString()
    }
}