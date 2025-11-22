package vehiculos;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    private double velocidad;
    public Vehiculo(String marca, String modelo, double velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }


    public abstract String tipo();

    public String describir() {
        return marca + " " + modelo + " " + velocidad;
    }

    public void acelerar() {
        velocidad +=10;
        System.out.println("Velocidad acelerada a "+ velocidad);
    }

    public void acelerar(double incremento) {
        velocidad += incremento;
        System.out.println(modelo + " acelero a " + velocidad + " km/h");
    }

    public void frenar(double decremento) {
        velocidad -= decremento;
        if (velocidad < 0) velocidad = 0;
        System.out.println(modelo + " frenó a " + velocidad + " km/h");
    }
}
