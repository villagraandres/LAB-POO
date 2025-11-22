import vehiculos.*;
import interfaces.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Auto a1 = new Auto("Toyota", "Corolla", 50.0);
        Moto m1 = new Moto("Honda", "CBR", 40.0);

        Hibrido h1 = new Hibrido("Toyota ", "Prius", 30.0);
        AutoElectrico ae1 = new AutoElectrico("Tesla", "Modelo 9", 40.0);
        List<Vehiculo> flota = Arrays.asList(h1, a1, m1, ae1);

        try (RecursoLog log = new RecursoLog()) {
            for (Vehiculo v : flota) {
                System.out.println("Tipo: " + v.tipo());
                System.out.println(v.describir());
                v.acelerar();
                v.frenar(5);

                if (v instanceof ICombustion c) {
                    c.repostar();
                    System.out.println("Combustible: " + c.tipoComb());
                }
                if (v instanceof IElectrico e) {
                    e.cargar();
                    System.out.println("Nivel batería: " + e.nivelBateria());
                }

                System.out.println("--------------");
            }

        }


    }
}
