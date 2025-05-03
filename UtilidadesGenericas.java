import java.util.*;

public class UtilidadesGenericas {

    // a. Buscar un elemento genérico en una lista
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    // b. Invertir una lista genérica
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInvertida.add(lista.get(i));
        }
        return listaInvertida;
    }

    // Definición de Node<T> para trabajar con listas enlazadas
    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // c. Insertar un nodo al final
    public static <T> void insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevoNodo = new Node<>(valor);
        if (head == null) {
            // No es posible cambiar head aquí porque Java pasa por valor,
            // deberías manejar esto con un return si head puede ser null.
            System.out.println("La cabeza es null. Inserción no realizada.");
            return;
        }
        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevoNodo;
    }

    // d. Contar los nodos
    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    // e. Comparar dos listas enlazadas
    public static <T> boolean sonIguales(Node<T> head1, Node<T> head2) {
        Node<T> actual1 = head1;
        Node<T> actual2 = head2;
        while (actual1 != null && actual2 != null) {
            if (!actual1.data.equals(actual2.data)) {
                return false;
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }
        return actual1 == null && actual2 == null;
    }

    // f. Concatenar dos listas enlazadas
    public static <T> Node<T> concatenarListas(Node<T> head1, Node<T> head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node<T> actual = head1;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = head2;
        return head1;
    }
}
