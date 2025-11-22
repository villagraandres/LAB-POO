package vehiculos;
import interfaces.ICombustion;

public class Moto extends Vehiculo implements ICombustion {

    public Moto(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
    }

    @Override
    public String tipo() {
        return "Moto";
    }

    @Override
    public void repostar() {
        System.out.println(modelo + " repostando combustible...");
    }

    @Override
    public String tipoComb() {
        return "Gasolina";
    }
}