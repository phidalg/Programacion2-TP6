package tp6;

import tp6.sistemastock.CategoriaProducto;
import tp6.sistemastock.Inventario;
import tp6.sistemastock.Producto;

/**
 *
 * @author Pedro Hidalgo
 */
public class Main {

    public static void main(String[] args) {
        
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
                new Producto("p008","Pan hamburguesas x 4",600,18,CategoriaProducto.ALIMENTOS));
        
        inventario.listarProductos();
        
    }
    
}