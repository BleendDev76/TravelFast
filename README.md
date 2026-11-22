# TravelFast

Simulador de compra de pasajes por consola, escrito en Kotlin. Modela clientes con
categoría, pasajes aéreos y terrestres con recargos propios, y una reserva que calcula
subtotal, descuento, cargos administrativos e impuestos antes de emitir el pasaje.

## Modelo

- `Pasaje` (clase abstracta) → `PasajeAereo` (recargo por clase ejecutiva) y
  `PasajeTerrestre` (recargo VIP).
- `Cliente` con `CategoriaCliente`: Regular, Frecuente o Premium. La categoría define
  el descuento aplicado.
- `Reserva` agrupa cliente y pasajes y calcula el total.
- `EstadoReserva` es un `sealed class` que recorre los estados Pendiente → Confirmado →
  Emitido con corrutinas y pausas de 3 segundos.

## Requisitos

- JDK 21 o superior (el proyecto usa toolchain 25)

## Ejecutar

```bash
./gradlew run
```

También se puede abrir en IntelliJ IDEA y ejecutar `Main.kt`.

## Estructura

```
src/main/kotlin/
├── Main.kt
├── model/
│   ├── CategoriaCliente.kt
│   ├── Cliente.kt
│   ├── Pasaje.kt
│   ├── PasajeAereo.kt
│   ├── PasajeTerrestre.kt
│   └── Reserva.kt
└── sealed/
    └── EstadoReserva.kt
```

## Ejemplo de uso

```
Ingresa nombre del cliente:
Cristobal
Selecciona la categoria del cliente:
1.- Regular
2.- Frecuente
3.- Premium
3

=== Travel Fast ===
1.- Santiago - Tokio
2.- Santiago - Puerto Varas
3.- Terminar Compra
```
