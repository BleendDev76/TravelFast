package cl.viajes.model

class PasajeTerrestre (origen: String, destino: String, precioBase: Int, var vip: Boolean): Pasaje(origen, destino, precioBase) {
    override fun calcularPrecioFinal(): Int {
        var valor = precioBase
        if(vip) {
            valor += 10000
        }
        return valor
    }

    override fun toString(): String {
        return super.toString()
    }

}