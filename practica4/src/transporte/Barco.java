package transporte;

public class Barco extends Transporte implements INavegable {
    private double eslora;

    public Barco(String nombre, int capacidad, double eslora) {
        super(nombre, capacidad);
        this.eslora = eslora;
    }

    @Override
    public void mover() {
        System.out.println(nombre + " avanza sobre el agua.");
    }

    @Override
    public void navegar() {
        System.out.println(nombre + " está navegando en mar abierto.");
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Eslora: " + eslora + " metros");
    }
}
