public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

    private int autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaExtendida;

    // Inicializa una bicicleta eléctrica con sus datos generales y específicos.
    public BicicletaElectrica(String codigoBicicleta,
                              int anioFabricacion,
                              double peso,
                              int autonomiaKm,
                              boolean bateriaCertificada) {

        super(codigoBicicleta, anioFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendida = false;
    }

    // Retorna la autonomía disponible en kilómetros.
    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    // Asigna la autonomía después de validar que sea mayor que cero.
    public void setAutonomiaKm(int autonomiaKm) {
        if (autonomiaKm <= 0) {
            throw new IllegalArgumentException("La autonomía debe ser mayor que cero.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    // Indica si la batería de la bicicleta está certificada.
    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    // Establece el estado de certificación de la batería.
    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    // Calcula la mantención, agregando un recargo si la batería no está certificada.
    @Override
    public double calcularCostoMantencion() {
        double costo = 45000;

        if (!bateriaCertificada) {
            costo *= 1.25;
        }

        return costo;
    }

    // Indica si la garantía extendida se encuentra activa.
    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendida;
    }

    // Activa la garantía extendida de la bicicleta eléctrica.
    @Override
    public void activarGarantiaExtendida() {
        garantiaExtendida = true;
    }

    // Retorna la representación textual heredada de Bicicleta.
    @Override
    public String toString() {
        return super.toString();
    }
}
