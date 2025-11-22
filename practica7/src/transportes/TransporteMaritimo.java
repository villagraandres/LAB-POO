package transportes;

public class TransporteMaritimo extends Transporte implements IOperable {

    public TransporteMaritimo(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Marítimo";
    }

    @Override
    public void mover() {
        System.out.println("Navegando por mar");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento marino: revisión de casco y motores.");
    }
}
