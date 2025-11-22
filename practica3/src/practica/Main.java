package practica;

public class Main {
    public static void main(String[] args) {
            CuentaBancaria cuenta1=new CuentaBancaria("246011","Andres",180);

            cuenta1.getSaldo();

            cuenta1.depositar(500);

            cuenta1.depositar(-500);

            cuenta1.retirar(800);

            cuenta1.retirar(100);


        CuentaBancaria cuenta2=new CuentaBancaria("244011","Juan",-180);


    }
    }
