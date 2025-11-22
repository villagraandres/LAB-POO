package transporte;

public abstract class Transporte {
    protected String nombre;
    protected int capacidad;

    public Transporte(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public void encender() {
        System.out.println(nombre + " está encendiendo...");
    }

    public void apagar() {
        System.out.println(nombre + " se apaga.");
    }


    public abstract void mover();


    public void mostrarInfo() {
        System.out.println("Transporte: " + nombre + ", capacidad: " + capacidad);
    }
}
