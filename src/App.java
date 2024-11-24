import java.util.Scanner;

public class App {
    // Elementos necesariospara todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Marte", "Jupiter", "Saturno" };
    static double[] distancias = { 78.0, 628.0, 1256.0 };

    public static void main(String[] args) throws Exception {
        menuPrincipla();
        int opcion;
        do {
            // Leer la opción del usuario
            opcion = scanner.nextInt();

            // Manejo de opciones
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1. Seleccionar un planeta de destino.");
                    mostrarDestinos();
                    int seleccion = elegirDestino();
                    mostrarInformaciónDestino(seleccion);
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2 Seleccionar un planeta de destino.");
                    // Aquí puedes agregar la lógica para la opción 2
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3. Iniciar la simulación del viaje.\r");
                    // Aquí puedes agregar la lógica para la opción 3
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

            System.out.println(); // Línea en blanco para mejorar la legibilidad
        } while (opcion != 0);

    }

    public static void menuPrincipla() {
        System.out.println("Bienvenido al simulador de viaje espacial");

        // Encabezado del menú
        System.out.println("===================================");
        System.out.println("            MENÚ PRINCIPAL        ");
        System.out.println("===================================");

        // Opciones del menú
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial.");
        System.out.println("3. Iniciar la simulación del viaje.\r");
        System.out.println("0. Salir del programa");
        System.out.print("Seleccione una opción: ");

    }

    public static void mostrarDestinos() {
        System.out.println("Planetas de destino disponibles:");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i]);
        }
    }

    public static int elegirDestino() {
        int eleccion;
        System.out.print("Ingresa el número del destino: ");
        eleccion = scanner.nextInt();
        if (eleccion < 1 || eleccion > planetas.length) {
            System.out.println("Opción no válida. Selecciona un número entre 1 y " + planetas.length);
            return elegirDestino(); // Volver a solicitar si la opción es inválida
        }
        return eleccion - 1; // Convertir a índice
    }

    public static void mostrarInformaciónDestino(int eleccion) {
        System.out.println("Información del destino seleccionado:");
        System.out.println("Planeta: " + planetas[eleccion]);
        System.out.println("Distancia desde la Tierra: " + distancias[eleccion] + " millones de kilómetros.");

        // Pausa antes de volver al menú principal
        System.out.println("Presiona Enter para volver al menú principal...");
        scanner.nextLine(); // Consume cualquier entrada pendiente
        scanner.nextLine(); // Espera que el usuario presione Enter

        // Regresar al menú principal
        menuPrincipla();
    }

}
