import java.util.*;

public class LaboratorioColecciones {
    public static void main(String[] args) {

        System.out.println("== ArrayList: Exhibición ==");
        ArrayList<Producto> listaExhibicion = new ArrayList<>();
        listaExhibicion.add(new Producto(1, "Teclado", "Perifericos"));
        listaExhibicion.add(new Producto(2, "Mouse", "Perifericos"));
        listaExhibicion.add(new Producto(3, "Monitor", "Pantallas"));
        listaExhibicion.add(new Producto(4, "Cable HDMI", "Oferta"));

        for (Producto p : listaExhibicion)
            System.out.println(p);

        System.out.println("\n== LinkedList: Reabastecer ==");
        LinkedList<Producto> colaReabastecer = new LinkedList<>();
        colaReabastecer.addFirst(new Producto(6, "Webcam", "Perifericos"));
        colaReabastecer.addLast(new Producto(5, "Laptop", "Computo"));

        for (Producto p : colaReabastecer)
            System.out.println(p);

        System.out.println("\n== HashSet: Categorías únicas ==");
        HashSet<String> categorias = new HashSet<>();
        for (Producto p : listaExhibicion)
            categorias.add(p.getCategoria());
        for (Producto p : colaReabastecer)
            categorias.add(p.getCategoria());
        System.out.println(categorias);

        System.out.println("\n== HashMap: Consulta por id ==");
        HashMap<Integer, Producto> mapaPorId = new HashMap<>();
        for (Producto p : listaExhibicion)
            mapaPorId.put(p.getId(), p);
        for (Producto p : colaReabastecer)
            mapaPorId.put(p.getId(), p);

        System.out.println("id=3 -> " + mapaPorId.get(3));

        System.out.println("\nRecorriendo HashMap (entrySet):");
        for (Map.Entry<Integer, Producto> e : mapaPorId.entrySet())
            System.out.println(e.getKey() + " -> " + e.getValue());

        System.out.println("\n== Iterator: eliminar categoría 'Oferta' en listaExhibicion ==");
        Iterator<Producto> it = listaExhibicion.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getCategoria().equals("Oferta"))
                it.remove();
        }

        System.out.println("Después de eliminar:");
        for (Producto p : listaExhibicion)
            System.out.println(p);
    }
}
