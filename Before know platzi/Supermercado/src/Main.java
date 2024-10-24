
public static void main(String[] args) {
    // Crear productos
    Producto producto1 = new Producto("Manzanas", 2.50);
    Producto producto2 = new Producto("Pan", 1.25);
    Producto producto3 = new Producto("Leche", 3.00);
    Producto producto4 = new Producto("Arroz", 1.75);

    // Crear cliente y agregar productos al carrito
    Cliente cliente1 = new Cliente("Juan");
    cliente1.agregarProducto(producto1);
    cliente1.agregarProducto(producto2);
    cliente1.agregarProducto(producto3);

    Cliente cliente2 = new Cliente("Maria");
    cliente2.agregarProducto(producto3);
    cliente2.agregarProducto(producto4);

    // Crear cajera
    Cajera cajera = new Cajera("Laura");

    // Procesar compras
    cajera.procesarCompra(cliente1);
    cajera.procesarCompra(cliente2);
}
