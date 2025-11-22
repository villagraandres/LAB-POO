package vehiculos;
import  interfaces.IElectrico;
public class AutoElectrico extends Vehiculo implements IElectrico {
    private double bateria;

    public AutoElectrico(String marca, String modelo, double velocidad) {
        super(marca, modelo, velocidad);
        this.bateria = 100;
    }

    @Override
    public String tipo() {
        return "Auto Eléctrico";
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