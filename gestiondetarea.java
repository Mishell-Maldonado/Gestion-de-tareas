import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class gestiondetarea {

    public static void main(String[] args) {
        limpiarPantalla();

        Stack<String> pendientes = new Stack<>();
        Queue<String> completadas = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            try {
                // Se limpia en cada ciclo para que solo veas el menú actualizado
                limpiarPantalla();

                int numPendientes = pendientes.size();
                int numCompletadas = completadas.size();

                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║       GESTIÓN DE TAREAS - MISHELL          ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.println("----------------------------------------------");
                System.out.println(" Pendientes: " + numPendientes + " | Completadas: " + numCompletadas);
                System.out.println("----------------------------------------------");
                System.out.println("  1. Agregar nueva tarea");
                System.out.println("  2. Completar ");
                System.out.println("  3. Eliminar de la Pila ");
                System.out.println("  4. Ver lista de pendientes");
                System.out.println("  5. Ver próxima tarea ");
                System.out.println("  6. Ver historial de completadas");
                System.out.println("  7. Salir del sistema");
                System.out.print("\n  > Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- AGREGAR TAREA ---");
                        System.out.print("Descripción: ");
                        String nueva = sc.nextLine();
                        if (!nueva.trim().isEmpty()) {
                            pendientes.push(nueva); 
                            // Operación PUSH: Agrega un nuevo elemento a la cima de la pila
                            System.out.println(" Tarea guardada.");
                        } else {
                            System.out.println(" Descripción vacía.");
                        }
                        esperarEnter(sc);
                        break;

                    case 2:
                        System.out.println("\n--- COMPLETAR TAREA ---");
                        if (!pendientes.isEmpty()) {
                            String terminada = pendientes.pop(); 
                            completadas.offer(terminada); 
                            System.out.println(" '" + terminada + "' movida al historial.");
                        } else {
                            System.out.println(" No hay pendientes.");
                        }
                        esperarEnter(sc);
                        break;

                    case 3:
                        System.out.println("\n--- ELIMINAR DE PILA ---");
                        if (!pendientes.isEmpty()) {
                            System.out.println(" Se eliminó: " + pendientes.pop());
                        } else {
                            System.out.println(" Nada que eliminar.");
                        }
                        esperarEnter(sc);
                        break;
                    case 4:
                        System.out.println("\n--- LISTA DE PENDIENTES ---");
                        if (!pendientes.isEmpty()) {
                            int total = pendientes.size();
                            for (String t : pendientes) {
                                System.out.println("[" + total-- + "] " + t);
                            }
                        } else {
                            System.out.println(" No hay pendientes.");
                        }
                        esperarEnter(sc);
                        break;
                    case 5:
                        System.out.println("\n--- PRÓXIMA TAREA   ---");
                        if (!pendientes.isEmpty()) {
                            System.out.println(" " + pendientes.peek()); 
                        } else {
                            System.out.println(" La pila está vacía.");
                        }
                        esperarEnter(sc);
                        break;

                    case 6:
                        System.out.println("\n--- HISTORIAL  ---");
                        if (!completadas.isEmpty()) {
                            completadas.forEach(c -> System.out.println(" " + c));
                        } else {
                            System.out.println(" Historial vacío.");
                        }
                        esperarEnter(sc);
                        break;

                    case 7:
                        System.out.println("\n Saliendo...");
                        break;

                    default:
                        System.out.println("\n Opción inválida.");
                        esperarEnter(sc);
                }
            } catch (Exception e) {
                System.out.println("\n Error: Ingrese un número.");
                sc.nextLine(); 
                esperarEnter(sc);
            }
        } while (opcion != 7);
        sc.close();
    }
public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla el comando de sistema, usa el código ANSI como respaldo
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void esperarEnter(Scanner sc) {
        System.out.println("\n Presione ENTER para continuar...");
        sc.nextLine();
    }
}
