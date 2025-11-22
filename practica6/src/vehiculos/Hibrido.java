package vehiculos;

import interfaces.IElectrico;
import interfaces.ICombustion;

public class Hibrido extends Vehiculo implements ICombustion, IElectrico {

    private double bateria;

    public Hibrido(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
        this.bateria = 50;
    }

    @Override
    public String tipo() {
        return "Híbrido";
    }

    @Override
    public void repostar() {
        System.out.println(modelo + " repostando combustible...");
    }

    @Override
    public String tipoComb() {
        return "Gasolina";
    }

    @Override
    public void cargar() {
        bateria = 100;
        System.out.println(modelo + " cargando batería...");
    }

    @Override
    public double nivelBateria() {
        return bateria;
    }
}