package vehiculos;
import interfaces.ICombustion;
public class Auto extends Vehiculo implements ICombustion {

    public Auto(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
    }

    @Override
    public String tipo() {
        return "Auto";
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
