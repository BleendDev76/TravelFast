package cl.viajes.model

class Reserva (val cliente : Cliente, val listaPasaje : MutableList<Pasaje>) {
    fun subTotal(): Int{
        var total = 0

        listaPasaje.forEach {
            total += it.calcularPrecioFinal()
        }
        return total
    }

    fun descuento() : Double{
        var descuento = 0.0

        if (cliente.categoriaCliente == CategoriaCliente.REGLUAR) {
            descuento = subTotal() * 0.5
        } else if (cliente.categoriaCliente == CategoriaCliente.FRECUENTE) {
            descuento = subTotal() * 0.10
        } else if (cliente.categoriaCliente == CategoriaCliente.PREMIUM) {
            descuento = subTotal() * 0.20
        }
        return descuento
    }

    fun cargoAdministrativos(): Int {
        return listaPasaje.count() * 2000
    }

    fun impuesto(): Double {
        val base = subTotal() - descuento() + cargoAdministrativos()
        return base * 0.19
    }

    fun total(): Double {
        return subTotal() - descuento() + cargoAdministrativos() + impuesto()
    }
}