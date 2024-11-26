import java.util.Scanner;

public class App<Randon> {
    // Elementos necesariospara todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Marte", "Jupiter", "Saturno" };
    static double[] distancias = { 78.0, 628.0, 1256.0 };
    static String[] naveEspacial = { "Nave espacial 1", "Nave espacial 2" };
    static double[] velocidadNave = { 2, 21.56 }; // km/h
    static double[] combustibleNave = { 0.0003 , 0.0005 }; //toneladas/km.

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
                    mostrarInformacionDestino(seleccion);
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2. Seleccionar una nave espacial.");
                    naveEspacial();
                    int nave = seleccionNave();
                    informacionNave(nave);
                    int nPersonas = numeroPersonas();
                    int eleccion = 0;
                    double duracion= calculoDuracionViaje(eleccion , nave);
                    int s=0;
                    double cantidad= cantidadCombustible(s, nave);
                    
                    double oxigenoNecesario = cantidadOxigeno(duracion, nPersonas);
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3. Iniciar la simulación del viaje.\r");
                    // Aquí puedes agregar la lógica para la opción 3
                    break;
                case 0:
                    System.out.println("Ingresas cero para salir del programa...");
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

    public static void mostrarInformacionDestino(int eleccion) {
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

    // punto dos: todo lo relacionado con la nave espacial.
    public static void naveEspacial() {
        System.out.println("Naves espaciales disponibles:");
        for (int i = 0; i < naveEspacial.length; i++) {
            System.out.println((i + 1) + ". " + naveEspacial[i]);
        }
    }

    public static int seleccionNave() {
        int eleccion;
        System.out.print("Ingresa el número de la nave espacial: ");
        eleccion = scanner.nextInt();
        if (eleccion < 1 || eleccion > naveEspacial.length) {
            System.out.println("Opción no válida. Selecciona un número entre 1 y " + naveEspacial.length);
            return seleccionNave(); // Volver a solicitar si la opción es inválida
        }
        return eleccion - 1; // Convertir a índice
    }

    public static void informacionNave(int eleccion) {
        System.out.println("Información de la nave seleccionado:");
        System.out.println("Nave espacial: " + naveEspacial[eleccion]);
        System.out.println("Velocidad: " + velocidadNave[eleccion] + " km/s.");

    }

    public static int numeroPersonas() {
        System.out.println("¿Cuántas personas viajarán en la nave?");
        int eleccion = scanner.nextInt();
        if(eleccion >= 1){
            System.out.println("El número de personas seleccionado es: " + eleccion);
        }else{
            System.out.println("Opción no válida. Selecciona un número mayor 1");
            numeroPersonas();
        }
         return eleccion;
         // Pausa antes de volver al menú principal
        /* 
        System.out.println("Presiona Enter para volver al menú principal...");
         scanner.nextLine(); // Consume cualquier entrada pendiente
         scanner.nextLine(); // Espera que el usuario presione Enter
 
         // Regresar al menú principal
         menuPrincipla();*/
    }

    public static double calculoDuracionViaje(int eleccion, int nave) {
      double tiempo;
      double dias;
      tiempo = distancias[eleccion] / velocidadNave[nave];
      System.out.println("la nave "+ naveEspacial[eleccion]+" viajará durante: " + tiempo + " horas");
      dias = tiempo/24;
      System.out.println("la nave "+ naveEspacial[eleccion]+" viajará durante: " + dias + " días");
      return dias;
    }

    public static double cantidadCombustible(int eleccion, int seleccion) {
    double combustibleNesesario = combustibleNave[eleccion] * distancias[seleccion];
    System.out.println("El conbustible nesesario para hacer el viaje desde la tierra hasta"+ planetas[eleccion]+" en la nabe "+ naveEspacial[seleccion]+ " son: " + combustibleNesesario + " toneladas");
    return combustibleNesesario;
    }

    public static double cantidadOxigeno(double dias, int personas) {
        double oxigenoPorDias = 20.16; // kg/d por persona
        double oxigenoNecesario = oxigenoPorDias * dias * personas;
        System.out.println("El oxígeno necesario para " + personas + " personas durante " + dias + " días es: " + oxigenoNecesario + " kg.");
        return oxigenoNecesario;
    }
   
   
}
