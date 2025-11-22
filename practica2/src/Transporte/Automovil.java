package Transporte;

public class Automovil {

    String marca;
    String modelo;
    String color;
    int year;

    public Automovil(String marca, String modelo, String color, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.year = year;
    }

    public void acelerar(){
        System.out.println("Acelerando carro de marca: " + marca);
    }

    public void desacelerar(){
        System.out.println("Desacelando carro de modelo: " + modelo);
    }

    public void mostrarInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
    }

    public String getMarca() {
        return marca;
    }
}
