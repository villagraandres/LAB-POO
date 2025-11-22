package transporte;

public class Carro extends Transporte {
    private int velocidadMax;

    public Carro(String nombre, int capacidad, int velocidadMax) {
        super(nombre, capacidad);
        this.velocidadMax = velocidadMax;
    }

    @Override
    public void mover() {
        System.out.println(nombre + " está rodando en carretera.");
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Velocidad máxima: " + velocidadMax + " km/h");
    }

    public void acelerar() {
        System.out.println(nombre + " acelera...");
    }
}
