# Sistema de Parqueadero Inteligente - Java POO

Este proyecto consiste en un sistema funcional de gestión de parqueadero desarrollado en Java utilizando Programación Orientada a Objetos (POO). El sistema permite registrar vehículos, validar placas, generar recibos de ingreso y calcular tarifas dependiendo del tipo de vehículo.
El proyecto fue diseñado para demostrar la aplicación práctica de los principios fundamentales de POO mediante una solución modular, organizada y funcional ejecutada por consola.

# Objetivo del Proyecto

Desarrollar un sistema de parqueadero que permita gestionar el ingreso de vehículos aplicando:

- Encapsulamiento
- Herencia
- Polimorfismo
- Modularización
- Manejo de excepciones
- Validaciones
- Clases y objetos

# Funcionalidades

El sistema permite:

- Registrar carros y motos.
- Validar placas vehiculares.
- Generar recibos de parqueo.
- Calcular tarifas automáticamente.
- Manejar errores mediante excepciones.
- Ejecutar el sistema mediante consola haciendo uso de scanner.

# ¿Qué se utilizó?

- Java
- Visual Studio Code
- Excepciones personalizadas


# Estructura del Proyecto

```txt
funcional-project/
│
│
│
└──src/
        │
        ├── app/
        │   └── ParqueaderoApp.java
        │
        ├── model/
        │   ├── Vehiculo.java
        │   ├── Carro.java
        │   ├── Moto.java
        │   └── Recibo.java
        │
        ├── exception/
        │   └── PlacaInvalidaException.java
        │
        └── utils/
            └── Validaciones.java
