public abstract class Bicicleta {

    private String codigoBicicleta;
    private int anioFabricacion;
    private double peso;

    // Inicializa los datos comunes de cualquier tipo de bicicleta.
    public Bicicleta(String codigoBicicleta, int anioFabricacion, double peso) {
        setCodigoBicicleta(codigoBicicleta);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    // Retorna el código identificador de la bicicleta.
    public String getCodigoBicicleta() {
        return codigoBicicleta;
    }

    // Asigna el código después de validar que tenga contenido.
    public void setCodigoBicicleta(String codigoBicicleta) {
        if (codigoBicicleta == null || codigoBicicleta.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de bicicleta no puede ser nulo ni vacío.");
        }
        this.codigoBicicleta = codigoBicicleta;
    }

    // Retorna el año de fabricación de la bicicleta.
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    // Asigna el año de fabricación si se encuentra dentro del rango permitido.
    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año debe estar entre 2000 y 2026.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    // Retorna el peso de la bicicleta en kilogramos.
    public double getPeso() {
        return peso;
    }

    // Asigna el peso después de comprobar que sea válido.
    public void setPeso(double peso) {
        if (Double.isNaN(peso) || peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.peso = peso;
    }

    // Define el cálculo del costo de mantención que implementará cada subclase.
    public abstract double calcularCostoMantencion();

    // Genera una representación básica de la bicicleta para mostrarla en pantalla.
    @Override
    public String toString() {
        return "Código: " + codigoBicicleta +
                " | Año: " + anioFabricacion;
    }
}
