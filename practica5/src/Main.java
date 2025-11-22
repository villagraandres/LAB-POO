
import Animales.*;
public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Kira");
        Delfin delfin = new Delfin("Flipper");

        Aguila aguila = new Aguila("Aguila Mexicana");

        System.out.println(delfin.respirar());
        System.out.println(delfin.despertar());
        delfin.hacerSonido();
        System.out.println(delfin.comer());
        System.out.println(delfin.nadar());

        System.out.println("-----");


        System.out.println(aguila.respirar());
        aguila.hacerSonido();
        aguila.volar();
        System.out.println(aguila.comer());


        System.out.println("-----");

        System.out.println(perro.respirar());
        perro.hacerSonido();
        System.out.println(perro.comer());




    }
}
