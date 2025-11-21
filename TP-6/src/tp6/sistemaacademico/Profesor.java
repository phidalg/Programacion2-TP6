package tp6.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pedro Hidalgo
 */
public class Profesor {

    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void agregarCurso(Curso c) {
        if (c != null && !cursos.contains(c)) {
            cursos.add(c);
            if (c.getProfesor() != this) {
                c.setProfesor(this);
            }
        }
    }

    public void eliminarCurso(Curso c) {
        if (cursos.remove(c) && c.getProfesor() == this) {
            c.setProfesor(null);
        }
    }

    public List<Curso> getCursos() {
        return Collections.unmodifiableList(cursos);
    }

    public void listarCursos(){
        System.out.println("Cursos dictados por " + nombre + ':');
        for (Curso curso : cursos) {
            System.out.println();
            curso.mostrarInfo();
        }
    }
    
    public void mostrarInfo() {
        System.out.println(
                " " + nombre +
                "\n  Especialidad: " + especialidad +
                "\n  Responsable de " + cursos.size() + " cursos");
    }
    
    
}
