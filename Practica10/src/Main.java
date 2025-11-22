import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalLineas = new AtomicInteger(0);

        LectorArchivo sucursal1 = new LectorArchivo("sucursal1.txt", totalLineas);
        LectorArchivo sucursal2 = new LectorArchivo("sucursal2.txt", totalLineas);
        LectorArchivo sucursal3 = new LectorArchivo("sucursal3.txt", totalLineas);

        sucursal1.setName("Hilo-1");
        sucursal2.setName("Hilo-2");
        sucursal3.setName("Hilo-3");

        sucursal1.start();
        sucursal2.start();
        sucursal3.start();

        Thread contador = new Thread(() -> {
            try {
                sucursal1.join();
                sucursal2.join();
                sucursal3.join();
                System.out.println("Total de líneas leídas: " + totalLineas.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        contador.start();
    }
}
