import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class LectorArchivo extends Thread {
    private String nombreArchivo;
    private AtomicInteger contador;

    public LectorArchivo(String nombreArchivo, AtomicInteger contador) {
        this.nombreArchivo = nombreArchivo;
        this.contador = contador;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(getName() + " leyendo: " + linea);
                contador.incrementAndGet();
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
