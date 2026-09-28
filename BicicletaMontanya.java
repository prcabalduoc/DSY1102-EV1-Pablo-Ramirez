public class BicicletaMontanya extends Bicicleta {

    private int cantidadSuspensiones;

    // Inicializa una bicicleta de montaña con sus datos y suspensiones.
    public BicicletaMontanya(String codigoBicicleta,
                             int anioFabricacion,
                             double peso,
                             int cantidadSuspensiones) {

        super(codigoBicicleta, anioFabricacion, peso);
        setCantidadSuspensiones(cantidadSuspensiones);
    }

    // Retorna la cantidad de suspensiones de la bicicleta.
    public int getCantidadSuspensiones() {
        return cantidadSuspensiones;
    }

    // Asigna la cantidad de suspensiones después de validar que no sea negativa.
    public void setCantidadSuspensiones(int cantidadSuspensiones) {
        if (cantidadSuspensiones < 0) {
            throw new IllegalArgumentException("La cantidad de suspensiones no puede ser negativa.");
        }
        this.cantidadSuspensiones = cantidadSuspensiones;
    }

    // Calcula la mantención, agregando un recargo cuando hay más de una suspensión.
    @Override
    public double calcularCostoMantencion() {
        double costo = 30000;

        if (cantidadSuspensiones > 1) {
            costo *= 1.15;
        }

        return costo;
    }

    // Retorna la representación textual heredada de Bicicleta.
    @Override
    public String toString() {
        return super.toString();
    }
}
