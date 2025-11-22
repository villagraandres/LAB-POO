package Transporte;

public class Barco {

    String nombre;
    String tipo;
    int capacidadPasajeros;
    int year;


    public Barco(String nombre, String tipo, int capacidadPasajeros,int year) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.year = year;
    }


    public void navegar() {
        System.out.println("El barco " + nombre + " está navegando.");
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Capacidad: " + capacidadPasajeros + " pasajeros");
        System.out.println("Year: " + year);
    }

    public void acelerar() {
        System.out.println("El barco " + nombre + " está acelerando.");
    }

    public int getyear() {
        return this.year;
    }


}