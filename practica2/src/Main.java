import Transporte.Automovil;
import Transporte.Barco;

public class Main {
    public static void main(String[] args) {

        Automovil miAuto = new Automovil("Toyota", "Corolla", "Rojo", 2020);

        miAuto.mostrarInfo();
        miAuto.acelerar();
        miAuto.desacelerar();
        

        String marcaAuto = miAuto.getMarca();
        System.out.println("La marca del auto es: " + marcaAuto);




        Barco titanic = new Barco("Titanic", "Crucero", 3547, 1912);


        titanic.mostrarInfo();
        titanic.navegar();
        titanic.acelerar();

        int yearBarco = titanic.getyear();
        System.out.println("Año del barco: " + yearBarco);
    }
}