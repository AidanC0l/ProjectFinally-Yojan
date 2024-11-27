import java.util.Random;
import java.util.Scanner;

public class App<Randon> {
    // Elementos necesariospara todas las acciones.
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Marte", "Jupiter", "Saturno" };
    static double[] distancias = { 78.0, 628.0, 1256.0 };
    static String[] naveEspacial = { "Nave espacial 1", "Nave espacial 2" };
    static double[] velocidadNave = { 2, 21.56 }; // km/h
    static double[] combustibleNave = { 0.0003 , 0.0005 }; //toneladas/km.
    static int seleccion = -1;
    static int nave = -1;

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
                     seleccion = elegirDestino();
                    mostrarInformacionDestino(seleccion);
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2. Seleccionar una nave espacial.");
                    naveEspacial();
                     nave = seleccionNave();
                    informacionNave(nave);
                    /*int nPersonas = numeroPersonas();
                    int eleccion = 0;
                    double duracion= calculoDuracionViaje(eleccion , nave);
                    int s=0;
                    double cantidad= cantidadCombustible(s, nave);
                    
                    double oxigenoNecesario = cantidadOxigeno(duracion, nPersonas);

                    // Pausa antes de volver al menú principal
                    System.out.println("Presiona Enter para volver al menú principal...");
                    scanner.nextLine(); // Consume cualquier entrada pendiente
                    scanner.nextLine(); // Espera que el usuario presione Enter*/
                
                    // Regresar al menú principal
                    menuPrincipla();
                    
                    break;
                case 3:
                System.out.println("Has seleccionado la Opción 3. Iniciar la simulación del viaje.");

                if (seleccion == -1 || nave == -1) {
                    System.out.println("Primero debes seleccionar un destino y una nave en las opciones 1 y 2.");
                    break;
                }
                // Configurar los datos necesarios para la simulación
                double distanciaTotal = distancias[seleccion] * 1_000_000; // Convertir de millones de km a km
                double velocidad = velocidadNave[nave]; // Velocidad de la nave seleccionada
                double consumoCombustible = combustibleNave[nave];
                double consumoOxigeno = 20.16; // Oxígeno por día por persona
                int personas = numeroPersonas(); // Obtener el número de personas
            
                double[] recursos = new double[] {
                    consumoCombustible * distanciaTotal, // Total de combustible necesario
                    consumoOxigeno * (distanciaTotal / velocidad / 24) * personas // Total de oxígeno necesario
                };
                // Iniciar la simulación
                boolean resultado = simularEventosAleatorios(distanciaTotal, velocidad, recursos);
                if (resultado) {
                    System.out.println("\n¡Felicidades! El viaje fue exitoso y llegaste a tu destino.");
                } else {
                    System.out.println("\nEl viaje ha fallado. Por favor, inténtalo de nuevo.");
                }
            
                // Regresar al menú principal
                menuPrincipla();                    
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
   
    // Simulación de eventos
    public static boolean simularEventosAleatorios(double distanciaTotal, double velocidad, double[] recursos) {
        Random random = new Random();
        double progreso = 0;
        double tiempoTranscurrido = 0;
        double consumoCombustible = recursos[0];
        double consumoOxigeno = recursos[1];
    
        while (progreso < 100) {
            // Simula el avance del viaje
            double avance = random.nextDouble() * 10; // Avance aleatorio entre 0 y 10%
            progreso += avance;
            tiempoTranscurrido += (avance / 100) * (distanciaTotal / velocidad);
    
            // Consumo de recursos
            consumoCombustible -= avance * recursos[0] / 100;
            consumoOxigeno -= avance * recursos[1] / 100;
    
            // Mostrar progreso
            System.out.printf("\nProgreso del viaje: %.2f%%, Tiempo transcurrido: %.2f horas\n", progreso, tiempoTranscurrido);
            System.out.printf("Combustible restante: %.2f toneladas, Oxígeno restante: %.2f kg\n", consumoCombustible, consumoOxigeno);
    
            // Eventos aleatorios
            int evento = random.nextInt(10); // Generar eventos aleatorios (% de probabilidad por tipo)
            if (evento < 3) { // 30% de probabilidad de que ocurra un evento
                if (random.nextBoolean()) {
                    // Evento: Asteroides
                    System.out.println("\n¡Cuidado! Un cinturón de asteroides está bloqueando el camino.");
                    System.out.println("1. Cambiar de rumbo (consume combustible).");
                    System.out.println("2. Pasar en medio de los asteroides (50% de riesgo de estrellarse).");
                    int decision = scanner.nextInt();
                    if (decision == 1) {
                        consumoCombustible -= 20; // Consumir combustible
                        System.out.println("Rumbo cambiado, combustible consumido.");
                    } else if (decision == 2) {
                        if (random.nextBoolean()) { // 50% de probabilidad de colisión
                            System.out.println("¡La nave se estrelló con el asteroide! El viaje ha fallado.");
                            return false;
                        } else {
                            System.out.println("Lograste pasar entre los asteroides sin problemas.");
                        }
                    }
                } else {
                    // Evento: Errores del sistema
                    System.out.println("\n¡Error crítico en el sistema!");
                    if (random.nextBoolean()) {
                        // Fallo en el oxígeno
                        double oxigenoPerdido = random.nextDouble() * 25; // Perdida aleatoria entre 0 y 25 kg
                        consumoOxigeno -= oxigenoPerdido;
                        System.out.printf("Fallo en el sistema de oxígeno. Perdidos %.2f kg de oxígeno.\n", oxigenoPerdido);
                    } else {
                        // Fallo en el combustible
                        double combustiblePerdido = random.nextDouble() * 5; // Perdida aleatoria entre 0 y 5 toneladas
                        consumoCombustible -= combustiblePerdido;
                        System.out.printf("Fallo en el sistema de combustible. Perdidas %.2f toneladas de combustible.\n", combustiblePerdido);
                    }
                    // Reparación obligatoria
                    System.out.println("La nave necesita reparaciones. Esto atrasará el viaje.");
                    tiempoTranscurrido += 2; // Atrasar el viaje
                }
            }
    
            // Verificar si los recursos se agotaron
            if (consumoCombustible <= 0 || consumoOxigeno <= 0) {
                System.out.println("La nave se quedó sin recursos. El viaje ha fallado.");
                return false;
            }
        }
        System.out.println("\n¡Viaje exitoso! Llegaste a tu destino.");
        return true;
    }
   
   // Monitoreo del viaje
   public static void iniciarVuelo(double distancia, double velocidad, double combustible, double oxigeno, double duracion) {
        System.out.println("Iniciando vuelo...");
        double[] recursos = {combustible, oxigeno};
        boolean resultado = simularEventosAleatorios(distancia, velocidad, recursos);
        if (resultado) {
            System.out.println("El viaje ha concluido con éxito.");
        } else {
            System.out.println("El viaje ha fallado. Intenta nuevamente ajustando los recursos.");
        }
    }

}
