package tp6.sistemaacademico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Hidalgo
 */
public class Universidad {

    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarProfesor(Profesor p) {
        this.profesores.add(p);
    } 
    
    public void agregarCurso(Curso c) {
        this.cursos.add(c);
    }
    
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }
        return null;
    }
    
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }
    
    public void asignarProfesorACurso(String codigoCurso, String idProfesor){
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profe = buscarProfesorPorId(idProfesor);
        if (profe != null && curso != null) {
            curso.setProfesor(profe);
        }
    }
    
    public void listarCursos(){
        System.out.println("Cursos dictados en la " + nombre + ':');
        for (Curso curso : cursos) {
            System.out.println();
            curso.mostrarInfo();
        }
    }
    
    public void listarProfesores(){
        System.out.println("Profesores de la " + nombre + ':');
        for (Profesor profesor : profesores) {
            System.out.println();
            profesor.mostrarInfo();
        }
    }
    
    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);    
        if (curso != null) {
            if (curso.getProfesor() != null) {
                curso.setProfesor(null);
            }
        cursos.remove(curso);
        }
    }
    
    public void eliminarProfesor(String id) {
        Profesor profe = buscarProfesorPorId(id);
        if (profe != null) {
            List<String> cursosVacantes = new ArrayList<>();
            for (Curso curso : profe.getCursos()) {
                cursosVacantes.add(curso.getCodigo());
            }
            for (String codigo : cursosVacantes) {
                buscarCursoPorCodigo(codigo).setProfesor(null);
            }
        }
        profesores.remove(profe);
    }
    
}
