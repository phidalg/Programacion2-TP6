package tp6.sistemabiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Hidalgo
 */
public class Biblioteca {

    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        System.out.println("Se ha creado la biblioteca \"" + nombre + '"');
    }

    public String getNombre() {
        return nombre;
    }
    
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro l = new Libro(isbn, titulo, anioPublicacion, autor);
        this.libros.add(l);
    }
    
    public void listarLibros() {
        System.out.println("Lista completa de libros en " + nombre + ':');
        for (Libro libro : libros) {
            System.out.println();
            libro.mostrarInfo();
        }
    }
    
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    
    public void eliminarLibro(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }
    
    public int obtenerCantidadLibros() {
        return this.libros.size();
    }
    
    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }
    
    public List<Autor> autoresDisponibles() {
        ArrayList<Autor> autoresEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            Autor autor = libro.getAutor();
            if (!autoresEncontrados.contains(autor)) {
                autoresEncontrados.add(autor);
            }
        }
        return autoresEncontrados;
    }
    
    public void mostrarAutoresDisponibles() {
        System.out.println("Autores disponibles en" + nombre + ':');
        for (Autor autor : autoresDisponibles()) {
            System.out.println(" - " + autor.getNombre());
        }
    }
    
}