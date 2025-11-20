package tp6.sistemastock;

import java.util.Objects;

/**
 *
 * @author Pedro Hidalgo
 */
public class Producto {

    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto() {
    }

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public void mostrarInfo() {
        System.out.println(
                " " + nombre +
                "\n  id: " + id +
                "\n  Precio: $" + precio +
                "\n  Stock disponible: " + cantidad +
                "\n  Categoría: " + categoria.name()
        );
    }
    
    @Override
    public String toString() {
        return  "Producto{" + 
                "\n  id: " + id +
                "\n  nombre: " + nombre +
                "\n  precio: " + precio + 
                "\n  cantidad: " + cantidad + 
                "\n  categoria: " + categoria +
                "\n}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

}