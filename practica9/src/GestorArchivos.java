import java.io.*;
import java.nio.file.*;
import java.util.*;

public class GestorArchivos {

    private static final File carpeta = new File("datos");
    private static final File archivo = new File("datos/productos.txt");
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("Carpeta 'datos' creada.");
        } else {
            System.out.println("Carpeta 'datos' ya existe.");
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = pedirEntero("Elige una opción: ", 1, 8);

            switch (opcion) {
                case 1 -> agregarProductos();
                case 2 -> leerProductos();
                case 3 -> buscarProducto();
                case 4 -> mostrarArchivos();
                case 5 -> crearArchivoCategorias();
                case 6 -> contarProductos();
                case 7 -> borrarArchivo();
                case 8 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }

    public static void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Agregar productos");
        System.out.println("2. Leer archivo de productos");
        System.out.println("3. Buscar producto por nombre");
        System.out.println("4. Mostrar archivos en la carpeta 'datos'");
        System.out.println("5. Crear archivo de categorías únicas");
        System.out.println("6. Contar productos registrados");
        System.out.println("7. Borrar archivo productos.txt");
        System.out.println("8. Salir");
    }

    public static void agregarProductos() {
        int n = pedirEntero("¿Cuántos productos quieres agregar?: ", 1, Integer.MAX_VALUE);
        Set<Integer> idsExistentes = leerIdsExistentes();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 1; i <= n; i++) {
                System.out.println("\nProducto #" + i);

                int id;
                while (true) {
                    id = pedirEntero("ID: ", 1, Integer.MAX_VALUE);
                    if (idsExistentes.contains(id)) {
                        System.out.println("El ID ya existe. Ingresa otro.");
                    } else {
                        idsExistentes.add(id);
                        break;
                    }
                }

                String nombre;
                do {
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine().trim();
                    if (nombre.isEmpty()) System.out.println("El nombre no puede estar vacío.");
                } while (nombre.isEmpty());

                String categoria;
                do {
                    System.out.print("Categoría: ");
                    categoria = sc.nextLine().trim();
                    if (categoria.isEmpty()) System.out.println("La categoría no puede estar vacía.");
                } while (categoria.isEmpty());

                bw.write(id + "," + nombre.replace(",", " ") + "," + categoria.replace(",", " "));
                bw.newLine();
            }
            System.out.println("\nProductos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void leerProductos() {
        System.out.println("\n=== Lectura del archivo ===");
        if (!archivo.exists()) {
            System.out.println("No hay registros para mostrar.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    public static void buscarProducto() {
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }
        System.out.print("\nNombre del producto a buscar: ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
            return;
        }
        if (!encontrado) System.out.println("No se encontraron productos con ese nombre.");
    }

    public static void mostrarArchivos() {
        System.out.println("\n=== Archivos en la carpeta 'datos' ===");
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("La carpeta 'datos' está vacía.");
            return;
        }
        for (File f : archivos) {
            if (f.isFile()) {
                System.out.println("Archivo: " + f.getName());
            }
        }
    }

    public static void crearArchivoCategorias() {
        if (!archivo.exists()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        Set<String> categorias = new LinkedHashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 3);
                if (partes.length == 3) {
                    String categoria = partes[2].trim();
                    if (!categoria.isEmpty()) categorias.add(categoria);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer productos: " + e.getMessage());
            return;
        }
        File archivoCategorias = new File("datos/categorias.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCategorias))) {
            for (String c : categorias) {
                bw.write(c);
                bw.newLine();
            }
            System.out.println("Archivo 'categorias.txt' creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear categorias.txt: " + e.getMessage());
        }
    }

    public static void contarProductos() {
        if (!archivo.exists()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.readLine() != null) count++;
        } catch (IOException e) {
            System.out.println("Error al contar: " + e.getMessage());
            return;
        }
        System.out.println("Total de productos registrados: " + count);
    }

    public static void borrarArchivo() {
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }
        System.out.print("¿Seguro que deseas borrar productos.txt? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();
        if (respuesta.equals("s") || respuesta.equals("si")) {
            if (archivo.delete()) {
                System.out.println("Archivo eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    public static int pedirEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor < min || valor > max) {
                    System.out.println("Ingresa un número válido entre " + min + " y " + max + ".");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número entero.");
            }
        }
    }

    public static Set<Integer> leerIdsExistentes() {
        Set<Integer> ids = new HashSet<>();
        if (!archivo.exists()) return ids;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 3);
                if (partes.length >= 1) {
                    try {
                        ids.add(Integer.parseInt(partes[0].trim()));
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (IOException ignored) {
        }
        return ids;
    }
}
