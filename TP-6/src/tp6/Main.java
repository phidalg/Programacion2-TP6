package tp6;

import java.util.ArrayList;
import tp6.sistemastock.CategoriaProducto;
import tp6.sistemastock.Inventario;
import tp6.sistemastock.Producto;

/**
 *
 * @author Pedro Hidalgo
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("\nCaso práctico I: Sistema de inventario\n");
        System.out.println(" Cargar productos al inventario y luego mostrar todos los productos del mismo:\n");
        
        Inventario inventario = new Inventario();
        
        inventario.agregarProducto(
                new Producto("p001","Teclado USB 100%",15448.50,10,CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(
                new Producto("p002","Monitor muchas pulgadas",55000,3,CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(
                new Producto("p003","Ratón inalámbrico",1520.60,25,CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(
                new Producto("p004","Lavarropas manual",110000,4,CategoriaProducto.HOGAR));
        inventario.agregarProducto(
                new Producto("p005","Heladera",500000.05,2,CategoriaProducto.HOGAR));
        inventario.agregarProducto(
                new Producto("p006","Remera básica",6500,50,CategoriaProducto.ROPA));
        inventario.agregarProducto(
                new Producto("p007","Pantalones Jean",30000,23,CategoriaProducto.ROPA));
        inventario.agregarProducto(
                new Producto("p008","Pan hamburguesas x 4",1000,18,CategoriaProducto.ALIMENTOS));
        
        inventario.listarProductos();
        
        System.out.println("\n Buscar producto por id y mostrar su información:\n");

        inventario.buscarProductoPorId("p004").mostrarInfo();
        
        System.out.println("\n Filtrar y mostrar productos que pertenezcan a una categoría específica\n");

        System.out.println(CategoriaProducto.ELECTRONICA.name());
        System.out.println(CategoriaProducto.ELECTRONICA.getDescripcion());
        for (Producto p : inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA)) {
            System.out.println();
            p.mostrarInfo();
        }
        
        System.out.println("\n Eliminar un producto por su ID y listar los productos restantes\n");
        
        System.out.println("Se elimina el teclado, la lista de productos queda así:\n");
        inventario.eliminarProducto("p001");
        inventario.listarProductos();
        
        System.out.println("\n Actualizar el stock de un producto existente\n");
        
        inventario.actualizarStock("p004", 100);
        inventario.buscarProductoPorId("p004").mostrarInfo();
        
        System.out.println("\n Mostrar el total de stock disponible\n");
        System.out.println("El stock total es: " + inventario.obtenerTotalStock());
        
        System.out.println("\n Obtener y mostrar el producto con mayor stock\n");
        for (Producto p : inventario.obtenerProductoConMayorStock()) {
            p.mostrarInfo();
        }

        System.out.println("\n Filtrar productos con precios entre $1000 y $3000\n");
        
        for (Producto p : inventario.filtrarProductosPorPrecio(1000, 3000)) {
            p.mostrarInfo();
            System.out.println();
        }
        
        System.out.println(" Mostrar las categorías disponibles con sus descripciones\n");
        inventario.mostrarCategoriasDisponibles();
    }
    
}