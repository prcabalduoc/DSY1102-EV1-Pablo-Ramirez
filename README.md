# Taller de bicicletas

Aplicación de consola desarrollada en Java para registrar bicicletas eléctricas y de montaña, consultar sus datos y calcular el costo de mantención según las características de cada bicicleta.

## Funcionalidades

- Registro de bicicletas eléctricas y de montaña.
- Búsqueda de bicicletas mediante su código identificador.
- Listado de las bicicletas registradas.
- Cálculo polimórfico del costo de mantención.
- Activación y consulta de garantía extendida para bicicletas eléctricas.
- Validación de los datos ingresados.
- Presentación de costos con formato numérico chileno.

## Reglas de mantención

| Tipo de bicicleta | Costo base | Recargo |
| --- | ---: | --- |
| Eléctrica | $45.000 | 25 % si la batería no está certificada |
| Montaña | $30.000 | 15 % si tiene más de una suspensión |

## Conceptos aplicados

El proyecto utiliza distintos principios de programación orientada a objetos:

- **Abstracción:** `Bicicleta` define los atributos y comportamientos comunes.
- **Herencia:** `BicicletaElectrica` y `BicicletaMontanya` heredan de `Bicicleta`.
- **Polimorfismo:** cada tipo implementa su propio cálculo de mantención.
- **Encapsulamiento:** los atributos son privados y se modifican mediante métodos de acceso validados.
- **Interfaces:** `ConGarantiaExtendida` establece las operaciones relacionadas con la garantía.

## Estructura del proyecto

```text
.
├── Bicicleta.java
├── BicicletaElectrica.java
├── BicicletaMontanya.java
├── ConGarantiaExtendida.java
├── GestorTallerBicicletas.java
├── Main.java
└── README.md
```

## Requisitos

- JDK 16 o una versión posterior.
- IntelliJ IDEA u otro entorno compatible con Java (opcional).

El proyecto utiliza la comprobación de tipos con variables de patrón en `instanceof`, característica disponible desde Java 16.

## Ejecución en IntelliJ IDEA

1. Clona o descarga este repositorio.
2. Abre la carpeta del proyecto en IntelliJ IDEA.
3. Configura un JDK compatible en **File > Project Structure > Project SDK**.
4. Abre `Main.java`.
5. Ejecuta el método `main`.

## Compilación desde la terminal

Ubícate en la carpeta raíz del proyecto y ejecuta:

```bash
javac -encoding UTF-8 Bicicleta.java BicicletaElectrica.java BicicletaMontanya.java ConGarantiaExtendida.java GestorTallerBicicletas.java Main.java
java Main
```

## Ejemplo de salida

```text
=== AÑADIENDO BICICLETAS ===
BIC-E01 (BicicletaElectrica) registrada correctamente.
BIC-E02 (BicicletaElectrica) registrada correctamente.
BIC-M01 (BicicletaMontanya) registrada correctamente.
BIC-M02 (BicicletaMontanya) registrada correctamente.

=== COSTOS DE MANTENCIÓN ===
BIC-E01 -> $56.250
BIC-E02 -> $45.000
BIC-M01 -> $34.500
BIC-M02 -> $30.000
```

## Validaciones

La aplicación comprueba, entre otras condiciones, que:

- El código de la bicicleta no sea nulo ni esté vacío.
- El año de fabricación esté entre 2000 y 2026.
- El peso sea mayor que cero.
- La autonomía de una bicicleta eléctrica sea mayor que cero.
- La cantidad de suspensiones no sea negativa.
