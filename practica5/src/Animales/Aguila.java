package Animales;

public class Aguila extends Animal implements IVolar {

    public Aguila(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " hace un chillido");
    }

    @Override
    public void volar() {
        System.out.println(nombre + " está volando");
    }
}
