public class Cajera {

    private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente) {
        System.out.println("Cajera " + nombre + " procesando la compra del cliente " + cliente.getNombre());
        double total = 0;
        int numeroProducto = 1;

        for (Producto producto : cliente.getCarrito()) {
            System.out.println("Producto " + numeroProducto + ": " + producto);
            total += producto.getPrecio();
            numeroProducto++;
            esperar(1000);  // Simula el tiempo que tarda en pasar cada producto (1 segundo)
        }

        System.out.println("Total a pagar por " + cliente.getNombre() + ": $" + total);
        System.out.println("Compra procesada.\n");
    }

    // Simulación de tiempo de espera
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
