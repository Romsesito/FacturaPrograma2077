import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfaz {
    private Scanner scanner;
    private List<Producto> productos;
    private int cantidadUnidades;


    public Interfaz() {
        scanner = new Scanner(System.in);
        productos = new ArrayList<>();
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.print("\u001B[1m\u001B[3m");
            System.out.println("==========================================");
            System.out.println("Seleccione una opción:");
            System.out.print("\u001B[0m");
            System.out.println("1. Ingresar producto");
            System.out.println("2. Facturar producto");
            System.out.println("3. Imprimir factura");
            System.out.println("4. Borrar Productos");
            System.out.println("5. Salir");
            System.out.print("\u001B[1m\u001B[3m");
            System.out.println("==========================================");
            System.out.print("Ingrese una opción: ");
            System.out.print("\u001B[0m");

            opcion = scanner.nextLine().toLowerCase().charAt(0);

            switch (opcion) {
                case '1':
                    ingresarProducto();
                    break;
                case '2':
                    facturarProducto();
                    break;
                case '3':
                    imprimirFactura();
                    break;
                case '4':
                    borrarProducto();
                    break;

                case '5':
                    System.out.println("Finalizando Ejecucion");
                    return;
                default:
                    System.out.println("Opción invalida. Por favor, ingrese una opción valida.");
                    break;
            }

            System.out.println();
        } while (opcion != 'd');
    }

    private void ingresarProducto() {
        System.out.print("\u001B[1m\u001B[3m");
        System.out.println("==========================================");
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio normal del producto:");
        double precioNormal = scanner.nextDouble();
        System.out.println("Ingrese el precio al por mayor del producto:");
        double precioMayorista = scanner.nextDouble();
        System.out.println("Ingrese el número de unidades para aplicar el precio al por mayor:");
        int unidadesMayorista = scanner.nextInt();
        System.out.print("\u001B[0m");
        Producto producto = new Producto(nombre, precioNormal, precioMayorista, unidadesMayorista);
        productos.add(producto);

        scanner.nextLine();

        System.out.println("Producto ingresado exitosamente.");

        System.out.println("¿Desea ingresar otro producto? (S/N)");
        String respuesta = scanner.nextLine().toLowerCase();
        if (respuesta.equals("s")) {
            ingresarProducto();
        }
    }

    private void facturarProducto() {
        System.out.println("==========================================");

        if (productos.isEmpty()) {
            System.out.println("No hay productos ingresados. Por favor, ingrese al menos un producto.");
            return;
        }

        System.out.println("Seleccione un producto:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre() + " (Precio normal: $" + producto.getPrecioNormal() +
                    ") (Precio al por mayor, más de " + producto.getUnidadesMayorista() +
                    " unidades: $" + producto.getPrecioMayorista() + ")");
        }

        int opcionProducto = scanner.nextInt();

        if (opcionProducto < 1 || opcionProducto > productos.size()) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            return;
        }

        Producto productoSeleccionado = productos.get(opcionProducto - 1);

        System.out.println("Ingrese la cantidad de unidades del producto:");
        this.cantidadUnidades = scanner.nextInt();



        scanner.nextLine();
    }
    private static final String patito = "\u001B[33m";
    private static final String mrwhait = "\u001B[0m";

    private void imprimirFactura() {




        System.out.println("==========================================");

        if (productos.isEmpty()) {
            System.out.println("No hay productos ingresados. Por favor, ingrese al menos un producto.");
            return;
        }

        System.out.print(patito +"__     __ _    _  _____   _____\n");
        System.out.print("\\ \\   / /| |  | ||  __ \\ |_   _|\n");
        System.out.print(" \\ \\_/ / | |  | || |__) |  | |\n");
        System.out.print("  \\   /  | |  | ||  ___/   | |\n");
        System.out.print("   | |   | |__| || |      _| |_\n");
        System.out.print("   |_|    \\____/ |_|     |_____|\n" + mrwhait);

        System.out.println("----- DATOS DE FACTURACION -----");
        System.out.println("Ingrese el nombre del comprador:");
        String nombreComprador = scanner.nextLine();
        System.out.println("Ingrese el número de cédula del comprador:");
        String cedulaComprador = scanner.nextLine();

        System.out.println("Productos:");
        double subtotal = 0.0;

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            double precioProducto = producto.getPrecioNormal();

            if (this.cantidadUnidades >= producto.getUnidadesMayorista()) {
                precioProducto = producto.getPrecioMayorista();
            }

            double precioTotalProducto = precioProducto * this.cantidadUnidades;
            subtotal += precioTotalProducto;

            System.out.println((i + 1) + ". " + producto.getNombre() + " x " + this.cantidadUnidades +
                    " (Precio unitario: $" + precioProducto + ") (Total: $" + precioTotalProducto + ")");
        }

        double descuento = Descuento.calcularDescuento(subtotal);
        double totalConDescuento = Descuento.calcularTotalConDescuento(subtotal);
        System.out.println("==========================================");
        System.out.println("Cliente: " + nombreComprador);
        System.out.println("Cédula del comprador: " + cedulaComprador);
        System.out.println("==========================================");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: " + (descuento * 100) + "%");
        System.out.println("Total con descuento: $" + totalConDescuento);
        System.out.println("==========================================");
        System.out.print(patito +"__     __ _    _  _____   _____\n");
        System.out.print("\\ \\   / /| |  | ||  __ \\ |_   _|\n");
        System.out.print(" \\ \\_/ / | |  | || |__) |  | |\n");
        System.out.print("  \\   /  | |  | ||  ___/   | |\n");
        System.out.print("   | |   | |__| || |      _| |_\n");
        System.out.print("   |_|    \\____/ |_|     |_____|\n" + mrwhait);
    }


    private void borrarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en lista.");
            return;
        }

        System.out.println("Seleccione un producto para borrar:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre());
        }

        int opcionProducto = scanner.nextInt();
        scanner.nextLine();

        if (opcionProducto < 1 || opcionProducto > productos.size()) {
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            return;
        }

        Producto productoBorrar = productos.get(opcionProducto - 1);
        productos.remove(productoBorrar);
        System.out.println("Producto borrado exitosamente.");
    }

}


