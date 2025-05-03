import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        List<Tarea> tareasCompletadas = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Imprimir todas las tareas");
            System.out.println("4. Verificar si una tarea existe");
            System.out.println("5. Invertir la lista de tareas");
            System.out.println("6. Completar una tarea (mover a completadas)");
            System.out.println("7. Mostrar tareas actuales y completadas");
            // Nuevas opciones
            System.out.println("8. Buscar tarea en completadas (genérico)");
            System.out.println("9. Invertir lista de completadas (genérico)");
            System.out.println("10. Operaciones sobre listas enlazadas (nodos)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: // Agregar tarea
                    System.out.print("Ingrese título de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese prioridad (número, menor = mayor prioridad): ");
                    int prioridad = scanner.nextInt();
                    gestor.agregarTarea(new Tarea(titulo, prioridad));
                    System.out.println("Tarea agregada.");
                    break;

                case 2: // Eliminar tarea
                    System.out.print("Ingrese el título de la tarea a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    gestor.eliminarTarea(tituloEliminar);
                    break;

                case 3: // Imprimir todas las tareas
                    gestor.mostrarTareas();
                    break;

                case 4: // Verificar existencia
                    System.out.print("Ingrese título de la tarea a buscar: ");
                    String buscarTitulo = scanner.nextLine();
                    boolean existe = gestor.existeTarea(buscarTitulo);
                    System.out.println(existe ? "La tarea existe." : "La tarea no existe.");
                    break;

                case 5: // Invertir lista
                    gestor.invertirTareas();
                    System.out.println("Lista de tareas invertida.");
                    break;

                case 6: // Transferir tarea a completadas
                    System.out.print("Ingrese el título de la tarea completada: ");
                    String tituloCompletada = scanner.nextLine();
                    Tarea completada = gestor.transferirTarea(tituloCompletada);
                    if (completada != null) {
                        tareasCompletadas.add(completada);
                        System.out.println("Tarea transferida a completadas.");
                    } else {
                        System.out.println("No se encontró la tarea.");
                    }
                    break;

                case 7: // Mostrar ambas listas
                    System.out.println("Tareas actuales:");
                    gestor.mostrarTareas();
                    System.out.println("\nTareas completadas:");
                    if (tareasCompletadas.isEmpty()) {
                        System.out.println("(Ninguna tarea completada aún.)");
                    } else {
                        for (Tarea t : tareasCompletadas) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 8: // Buscar tarea en completadas usando buscarElemento genérico
                    System.out.print("Ingrese título de la tarea a buscar en completadas: ");
                    String tituloBuscar = scanner.nextLine();
                    boolean encontrada = UtilidadesGenericas.buscarElemento(tareasCompletadas, new Tarea(tituloBuscar, 0));
                    System.out.println(encontrada ? "La tarea completada existe." : "No existe en tareas completadas.");
                    break;

                case 9: // Invertir lista de completadas usando invertirLista genérico
                    tareasCompletadas = UtilidadesGenericas.invertirLista(tareasCompletadas);
                    System.out.println("Lista de tareas completadas invertida.");
                    break;

                case 10: // Operaciones sobre nodos enlazados
                    System.out.println("--- Operaciones con nodos enlazados ---");
                    UtilidadesGenericas.Node<Tarea> head1 = new UtilidadesGenericas.Node<>(new Tarea("Tarea1", 1));
                    UtilidadesGenericas.insertarAlFinal(head1, new Tarea("Tarea2", 2));
                    UtilidadesGenericas.insertarAlFinal(head1, new Tarea("Tarea3", 3));

                    UtilidadesGenericas.Node<Tarea> head2 = new UtilidadesGenericas.Node<>(new Tarea("Tarea4", 4));
                    UtilidadesGenericas.insertarAlFinal(head2, new Tarea("Tarea5", 5));

                    System.out.println("Nodos en head1: " + UtilidadesGenericas.contarNodos(head1));
                    System.out.println("Nodos en head2: " + UtilidadesGenericas.contarNodos(head2));

                    boolean iguales = UtilidadesGenericas.sonIguales(head1, head2);
                    System.out.println(iguales ? "Las listas son iguales." : "Las listas NO son iguales.");

                    UtilidadesGenericas.Node<Tarea> listaConcatenada = UtilidadesGenericas.concatenarListas(head1, head2);
                    System.out.println("Lista concatenada:");
                    UtilidadesGenericas.Node<Tarea> actual = listaConcatenada;
                    while (actual != null) {
                        System.out.println(actual.data);
                        actual = actual.next;
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
