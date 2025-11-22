import transportes.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transporte> transportes = new ArrayList<>();


        transportes.add(new TransporteMaritimo("titanic", 100));
        transportes.add(new TransporteTerrestre("BUS", 50));
        transportes.add(new TransporteAereo("AV-777", 200));
        transportes.add(new TransporteFerroviario("La Bestia", 90));

        int pasajeros = 60;


        for (Transporte t : transportes) {
            t.mover();
            try {
                t.transportar(pasajeros);
            } catch (CapacidadExcedida e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            if (t instanceof IOperable) {
                ((IOperable) t).realizarMantenimiento();
            }
            System.out.println("---");
        }
    }
}
