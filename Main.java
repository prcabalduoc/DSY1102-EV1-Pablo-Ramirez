import java.util.List;

public class Main {

    // Ejecuta el flujo principal de creación, registro y consulta de bicicletas.
    public static void main(String[] args) {

        try {

            // Crear gestor de bicicletas
            GestorTallerBicicletas gestor = new GestorTallerBicicletas();

            // Crear colección de bicicletas
            List<Bicicleta> bicicletas = List.of(
                    new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false),
                    new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true),
                    new BicicletaMontanya("BIC-M01", 2021, 13.5, 2),
                    new BicicletaMontanya("BIC-M02", 2020, 12.0, 1)
            );

            // Bicicleta con características especiales
            String codigoEspecial = "BIC-E01";

            // Registrar bicicletas y activar garantía según condición
            System.out.println("\n=== AÑADIENDO BICICLETAS ===");
            for (Bicicleta bicicleta : bicicletas) {

                gestor.registrarBicicleta(bicicleta);

                if (bicicleta instanceof BicicletaElectrica electrica
                        && electrica.getCodigoBicicleta().equals(codigoEspecial)) {

                    electrica.activarGarantiaExtendida();

                }
            }

            // Buscar bicicleta por código
            Bicicleta encontrada = gestor.buscarPorCodigo(codigoEspecial);

            // Listar bicicletas
            System.out.println("\n=== LISTADO DE BICICLETAS ===");
            gestor.listarBicicletas();

            // Costos de mantención
            System.out.println("\n=== COSTOS DE MANTENCIÓN ===");
            gestor.mostrarCostosMantencion();

            // Verificar garantía extendida
            if (encontrada instanceof BicicletaElectrica electrica) {
                System.out.println("\nGarantía extendida BIC-E01: "
                        + electrica.tieneGarantiaExtendida());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
