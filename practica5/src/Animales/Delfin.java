package Animales;

public class Delfin extends Animal {

    public Delfin(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " hace sonido");
    }

    public String nadar() {
        return nombre + " nadando";
    }

    public String despertar() {
        return nombre + " despertando";
    }
}
