package transporte;

public class Bicicleta extends Transporte {
    private boolean electrica;

    public Bicicleta(String nombre, int capacidad, boolean electrica) {
        super(nombre, capacidad);
        this.electrica = electrica;
    }

    @Override
    public void mover() {
        if (electrica) {
            System.out.println(nombre + " avanza con asistencia eléctrica.");
        } else {
            System.out.println(nombre + " avanza pedaleando.");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Es eléctrica?: " + (electrica ? "Sí" : "No"));
    }
}
