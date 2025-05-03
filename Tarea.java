public class Tarea implements Comparable<Tarea> {
    private String titulo;
    private int prioridad;
    private boolean realizada; // nuevo atributo

    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.realizada = false; // por defecto no realizada
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean estaRealizada() {
        return realizada;
    }

    public void marcarComoRealizada() {
        this.realizada = true;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return "Tarea{" +
               "titulo='" + titulo + '\'' +
               ", prioridad=" + prioridad +
               ", realizada=" + (realizada ? "Sí" : "No") +
               '}';
    }
}
