import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GestorTallerBicicletas {

    private ArrayList<Bicicleta> bicicletas;

    // Presenta los costos sin decimales y con separador de miles chileno.
    private String formatearCosto(double costo) {
        NumberFormat formato = NumberFormat.getNumberInstance(
                Locale.forLanguageTag("es-CL")
        );
        formato.setMaximumFractionDigits(0);

        return "$" + formato.format(costo);
    }

    // Inicializa la colección utilizada para almacenar las bicicletas.
    public GestorTallerBicicletas() {
        bicicletas = new ArrayList<>();
    }

    // Registra una bicicleta y confirma su incorporación en pantalla.
    public void registrarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
        System.out.println(bicicleta.getCodigoBicicleta()
                + " (" + bicicleta.getClass().getSimpleName() + ")"
                + " registrada correctamente.");
    }

    // Busca una bicicleta por su código y muestra el resultado detallado.
    public Bicicleta buscarPorCodigo(String codigo) {

        System.out.println("\n=== BÚSQUEDA POR CÓDIGO: \"" + codigo + "\" ===");

        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getCodigoBicicleta().equalsIgnoreCase(codigo)) {
                mostrarDetalleBusqueda(bicicleta);
                return bicicleta;
            }
        }

        System.out.println("No se encontró una bicicleta con ese código.");
        System.out.println("---");
        return null;
    }

    // Muestra los atributos y el costo correspondientes al tipo de bicicleta encontrada.
    private void mostrarDetalleBusqueda(Bicicleta bicicleta) {
        String datosComunes = " | Código: " + bicicleta.getCodigoBicicleta()
                + " | Año: " + bicicleta.getAnioFabricacion()
                + " | Peso: " + bicicleta.getPeso() + " kg";

        if (bicicleta instanceof BicicletaElectrica electrica) {
            System.out.println("Tipo: Bicicleta Eléctrica" + datosComunes
                    + " | Autonomía: " + electrica.getAutonomiaKm() + " km"
                    + " | Batería certificada: "
                    + (electrica.isBateriaCertificada() ? "Sí" : "No"));

            System.out.println("  Garantía extendida: "
                    + (electrica.tieneGarantiaExtendida() ? "Sí" : "No")
                    + " | Costo mantención: "
                    + formatearCosto(electrica.calcularCostoMantencion()));
        } else if (bicicleta instanceof BicicletaMontanya montanya) {
            System.out.println("Tipo: Bicicleta de Montaña" + datosComunes
                    + " | Suspensiones: " + montanya.getCantidadSuspensiones());

            System.out.println("  Costo mantención: "
                    + formatearCosto(montanya.calcularCostoMantencion()));
        }
    }

    // Muestra todas las bicicletas que se encuentran registradas.
    public void listarBicicletas() {

        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(bicicleta);
        }
    }

    // Calcula y muestra el costo de mantención de cada bicicleta registrada.
    public void mostrarCostosMantencion() {

        for (Bicicleta bicicleta : bicicletas) {
            System.out.println(
                    bicicleta.getCodigoBicicleta()
                            + " -> "
                            + formatearCosto(bicicleta.calcularCostoMantencion())
            );
        }
    }
}
