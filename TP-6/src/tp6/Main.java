package tp6;

import java.util.ArrayList;
import tp6.sistemaacademico.Curso;
import tp6.sistemaacademico.Profesor;
import tp6.sistemaacademico.Universidad;
import tp6.sistemabiblioteca.Autor;
import tp6.sistemabiblioteca.Biblioteca;
import tp6.sistemabiblioteca.Libro;
import tp6.sistemastock.CategoriaProducto;
import tp6.sistemastock.Inventario;
import tp6.sistemastock.Producto;

/**
 *
 * @author Pedro Hidalgo
 */
public class Main {
    
    public static void separar(String titulo) {
            System.out.println("\n*********************************************************************************************");
            System.out.println("\n" + titulo + "\n");
        }

    public static void main(String[] args) {
        
        separar("Caso práctico I: Sistema de inventario");
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
        
        separar("Caso práctico II: Sistema de biblioteca");
        
        System.out.println("Crear la biblioteca, agregar algunos libros y mostrar su información:\n");
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca de Babel");
        Autor a1 = new Autor("a01", "Jorge Luis Borges", "Argentina");
        Autor a2 = new Autor("a02", "Julio Cortázar", "Argentina, Francesa");
        Autor a3 = new Autor("a03", "José Hernández", "Argentina");
        biblioteca.agregarLibro("977-987-03-2749-2", "Historia universal de la infamia", 1935, a1);
        biblioteca.agregarLibro("978-950-04-2749-1", "El Aleph", 1949, a1);
        biblioteca.agregarLibro("678-910-23-4567-8", "Ficciones", 1944, a1);
        biblioteca.agregarLibro("789-012-34-5678-9", "Bestiario", 1951, a2);
        biblioteca.agregarLibro("890-123-45-6789-0", "El Gaucho Martín Fierro", 1872, a3);
        
        System.out.println();
        biblioteca.listarLibros();
        
        System.out.println("\nListar todos los autores de los libros disponibles en la biblioteca\n");
        
        biblioteca.mostrarAutoresDisponibles();
        
        System.out.println("\nInformación completa de los autores:\n");
        
        for (Autor a : biblioteca.autoresDisponibles()) {
            a.mostrarInfo();
            System.out.println();
        }
        
        System.out.println("\nBuscar un libro por su ISBN y mostrar su información\n");

        biblioteca.buscarLibroPorIsbn("678-910-23-4567-8").mostrarInfo();
        
        System.out.println("\nFiltrar y mostrar los libros publicados en un año específico (1872)\n");
        
        for (Libro libro : biblioteca.filtrarLibrosPorAnio(1872)) {
            libro.mostrarInfo();
        }
        
        System.out.println("\nEliminar un libro por su ISBN y listar los libros restantes");
        System.out.println("Se elimina El Aleph:\n");
        
        biblioteca.eliminarLibro("978-950-04-2749-1");
        biblioteca.listarLibros();
        
        System.out.println("\nMostrar la cantidad total de libros en la biblioteca\n");
        System.out.println("Libros disponibles en la " + biblioteca.getNombre() + ": " + biblioteca.obtenerCantidadLibros());
        
        separar("Caso práctico III: Sistema académico");
        
        Universidad utn = new Universidad("UTN");
        Profesor p1 = new Profesor("p01", "Fernando Fernandez", "Química");
        Profesor p2 = new Profesor("p02", "Martín Martínez", "Programación");
        Profesor p3 = new Profesor("p03", "Rosa Rosales", "Física");
        utn.agregarProfesor(p1);
        utn.agregarProfesor(p2);
        utn.agregarProfesor(p3);
        Curso c1 = new Curso("c01", "Química Orgánica");
        Curso c2 = new Curso("c02", "Programación I");
        Curso c3 = new Curso("c03", "Física I");
        Curso c4 = new Curso("c04", "Programación II");
        Curso c5 = new Curso("c05", "Probabilidad y estadística");
        utn.agregarCurso(c1);
        utn.agregarCurso(c2);
        utn.agregarCurso(c3);
        utn.agregarCurso(c4);
        utn.agregarCurso(c5);
        
        System.out.println("Se agregan los siguientes cursos y profesores:\n");
        utn.listarCursos();
        System.out.println();
        utn.listarProfesores();
        
        System.out.println("\nSe asignan pprrofesores a algunos cursos:\n");
        
        utn.asignarProfesorACurso("c01", "p01");
        utn.asignarProfesorACurso("c02", "p02");
        utn.asignarProfesorACurso("c03", "p03");
        utn.asignarProfesorACurso("c04", "p02");
        
        utn.listarCursos();
        
        System.out.println("\nCambiar el profesor de un curso y verificar que ambos lados quedan sincronizados:\n");
        
        utn.asignarProfesorACurso("c05", "p03");
        utn.buscarCursoPorCodigo("c05").mostrarInfo();
        System.out.println();
        utn.buscarProfesorPorId("p03").listarCursos();
        
        System.out.println("\nLista de cursos del profesor Martínez antes de eliminar un curso:\n");
        
        utn.buscarProfesorPorId("p02").listarCursos();
        utn.eliminarCurso("c04");
        System.out.println("\nLista de cursos del profesor Martínez luego de eliminar un curso:\n");
        utn.buscarProfesorPorId("p02").listarCursos();
        
        System.out.println("\nEstado del curso Programación I luego de eliminar al profesor Martínez:\n");
        utn.eliminarProfesor("p02");
        utn.buscarCursoPorCodigo("c02").mostrarInfo();
        
        System.out.println("\nCantidad de cursos por profesor:\n");
        
        utn.listarProfesores();
    }
    
}