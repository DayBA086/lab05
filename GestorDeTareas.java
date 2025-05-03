import java.util.*;

public class GestorDeTareas<T extends Tarea> {
    private List<T> listaTareas = new ArrayList<>();

    public void agregarTarea(T tarea) {
        listaTareas.add(tarea);
    }

    public void eliminarTarea(String titulo) {
        Iterator<T> it = listaTareas.iterator();
        boolean eliminado = false;
        while (it.hasNext()) {
            T tarea = it.next();
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                it.remove();
                eliminado = true;
                System.out.println("Tarea eliminada.");
                break;
            }
        }
        if (!eliminado) {
            System.out.println("Tarea no encontrada.");
        }
    }

    public void mostrarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("(No hay tareas.)");
        } else {
            for (T tarea : listaTareas) {
                System.out.println(tarea);
            }
        }
    }

    public boolean existeTarea(String titulo) {
        for (T tarea : listaTareas) {
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public void invertirTareas() {
        Collections.reverse(listaTareas);
    }

    public T transferirTarea(String titulo) {
        Iterator<T> it = listaTareas.iterator();
        while (it.hasNext()) {
            T tarea = it.next();
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                it.remove();
                return tarea;
            }
        }
        return null;
    }
    public void mostrarTareasRealizadas() {
        boolean hayRealizadas = false;
        for (T tarea : listaTareas) {
            if (tarea.estaRealizada()) {
                System.out.println(tarea);
                hayRealizadas = true;
            }
        }
        if (!hayRealizadas) {
            System.out.println("(No hay tareas realizadas.)");
        }
    }
    
    public void marcarTareaComoRealizada(String titulo) {
        for (T tarea : listaTareas) {
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                tarea.marcarComoRealizada();
                System.out.println("Tarea marcada como realizada.");
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }
    
    
}
