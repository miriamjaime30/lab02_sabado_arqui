package org.example.business;

import org.example.data.EstudianteRepository;
import java.util.List;

public class EstudianteService {
    private final EstudianteRepository repository;

    public EstudianteService() {
        this.repository = new EstudianteRepository();
    }

    public void registrar(Estudiante estudiante) {
        List<Estudiante> estudiantes = repository.listar();
        estudiantes.add(estudiante);
        repository.guardar(estudiantes);
    }

    public List<Estudiante> listar() {
        return repository.listar();
    }

    public boolean actualizar(Estudiante estudiante) {
        List<Estudiante> estudiantes = repository.listar();
        boolean encontrado = false;

        for (Estudiante e : estudiantes) {

            if (e.getId() == estudiante.getId()) {
                e.setNombre(estudiante.getNombre());
                e.setCorreo(estudiante.getCorreo());
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            repository.guardar(estudiantes);
        }

        return encontrado;
    }

    public boolean eliminar(int id) {
        List<Estudiante> estudiantes = repository.listar();
        boolean eliminado = estudiantes.removeIf(e -> e.getId() == id);

        if (eliminado) {
            repository.guardar(estudiantes);
        }

        return eliminado;
    }
}