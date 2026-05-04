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