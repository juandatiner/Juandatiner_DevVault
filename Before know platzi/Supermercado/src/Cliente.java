import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Producto> carrito;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carrito = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public String getNombre() {
        return nombre;
    }
}
