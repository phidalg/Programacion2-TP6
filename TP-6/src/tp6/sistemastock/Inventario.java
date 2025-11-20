package tp6.sistemastock;

import java.util.ArrayList;

/**
 *
 * @author Pedro Hidalgo
 */
public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }
    
    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println();
            producto.print();
        }
    }
    
    public Producto buscarProductoPorId(String id) {
        
    }
    
    public void eliminarProducto(String id) {
        
    }
    
    public void actualizarStock(String id, int nuevaCantidad) {
        
    }
    
    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        
    }
    
    public int obtenerTotalStock() {
        
    }
    
    public Producto obtenerProductoConMayorStock() {
        
    }
    
    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max) {
        
    }
    
    public void mostrarCategoriasDisponibles() {
        System.out.println("Categorías disponibles:\t");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.printf("%2d - %-12s %-30s%n", cat.ordinal() + 1, cat.name(), cat.getDescripcion());
        }
    }
    
}