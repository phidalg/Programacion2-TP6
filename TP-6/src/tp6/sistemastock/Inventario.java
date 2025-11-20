package tp6.sistemastock;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Pedro Hidalgo
 */
public class Inventario {

    private HashMap<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }
    
    public void agregarProducto(Producto p) {
        if (p != null && p.getId() != null) {
            this.productos.put(p.getId(),p);
        }
    }
    
    public void listarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : productos.values()) {
            System.out.println();
            producto.mostrarInfo();
        }
    }
    
    public Producto buscarProductoPorId(String id) {
        return this.productos.get(id);
    }
    
    public void eliminarProducto(String id) {
        this.productos.remove(id);
    }
    
    public void actualizarStock(String id, int nuevaCantidad) {
        Producto producto = this.productos.get(id);
        producto.setCantidad(nuevaCantidad);
        
    }
    
    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();        
        for (Producto prod : productos.values()) {
            if (prod.getCategoria() == categoria) {
                productosFiltrados.add(prod);
            }
        }
        return productosFiltrados;
    }
    
    public int obtenerTotalStock() {
        int total = 0;
        for (Producto prod : productos.values()) {
            total += prod.getCantidad();
        }
        return total;
    }
    
    public ArrayList<Producto> obtenerProductoConMayorStock() {
        ArrayList<Producto> productosMayorStock = new ArrayList<>();
        int mayorStock = 0;
        for (Producto producto : productos.values()) {
            if (producto.getCantidad() == mayorStock) {
                productosMayorStock.add(producto);
            } else if (producto.getCantidad() > mayorStock) {
                mayorStock = producto.getCantidad();
                productosMayorStock.clear();
                productosMayorStock.add(producto);
            }
        }
        return productosMayorStock;
    }
    
    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos.values()) {
            if (producto.getPrecio() >= min && producto.getPrecio() <= max) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    
    public void mostrarCategoriasDisponibles() {
        System.out.println("Categorías disponibles:\t");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.printf("%2d - %-12s %-30s%n", cat.ordinal() + 1, cat.name(), cat.getDescripcion());
        }
    }
    
}