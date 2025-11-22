public class RecursoLog implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Recurso cerrado correctamente");
    }
}