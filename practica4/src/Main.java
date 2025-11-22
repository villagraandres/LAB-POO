
import transporte.Transporte;
import transporte.Carro;
import transporte.Bicicleta;
import transporte.Barco;

public class Main {
    public static void main(String[] args) {

        Transporte t2 = new Bicicleta("Tesla", 1, true);
        Barco t3 = new Barco("Titanic", 1000, 100);
        Transporte t1 = new Carro("BMW", 2, 200);
        t1.encender();
        t1.mover();
        t1.mostrarInfo();
        System.out.println();

        t2.encender();
        t2.mover();
        t2.mostrarInfo();
        System.out.println();

        t3.encender();
        t3.mover();
        t3.mostrarInfo();
        t3.navegar();
        System.out.println();
    }
}
