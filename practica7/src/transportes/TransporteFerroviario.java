package transportes;

public class TransporteFerroviario extends Transporte implements IOperable {

    public TransporteFerroviario(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Ferroviario";
    }

    @Override
    public void mover() {
        System.out.println("Avanzando por rieles");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento ferroviario: revisión de vías y frenos.");
    }
}
