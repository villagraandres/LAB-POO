package Animales;

public abstract class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void hacerSonido();

    public String respirar() {
        return nombre + " respirando";
    }

    public String comer() {
        return nombre + " comiendo";
    }
}
