package practica;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        if(saldo<0){
            System.out.println("No puede haber saldo negativo. Se pondra 0");
            this.saldo = 0;
        }else{
            this.saldo = saldo;
        }

    }


    public void depositar(double monto){
        if(monto<0){
            System.out.println("El monto a depositivar no puede ser negativo");
        }else{
            saldo = saldo + monto;
            System.out.println("El nuevo saldo es de: "+saldo);
        }

    }


    public void retirar(double monto){
        if(monto<0){
            System.out.println("El monto a retirar no puede ser negativo");
        }else if(saldo<monto){
            System.out.println("No hay suficiente para retirar, el saldo que usted tiene es de "+saldo);
        }else{
            saldo=saldo-monto;
            System.out.println("El nuevo saldo es de: "+saldo);
        }
    }

    public void getSaldo(){
        System.out.println("El saldo es de: "+saldo);
    }


}
