package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Estudiante;
import uce.edu.ec.pa.infrastructure.repository.ArchivoInterceptor;
import uce.edu.ec.pa.infrastructure.repository.Auditoria;
import uce.edu.ec.pa.infrastructure.repository.EstudianteRepositoryImpl;

@ApplicationScoped
@Transactional
public class EstudianteService {

    @Inject
    private EstudianteRepositoryImpl estudianteRepo;

    // CREAR
    @Auditoria
    @ArchivoInterceptor
    public void guardar(Estudiante estudiante) {
        this.estudianteRepo.persist(estudiante);

    }

    // ACTUALIZAR
    @Auditoria
    public void actualizar(Integer id, String apellido, String nombre, String curso) {
        Estudiante estudiante = this.estudianteRepo.findById(id);
        if (estudiante != null) {
            estudiante.setApellido(apellido);
            estudiante.setNombre(nombre);
            estudiante.setCurso(curso);
            this.estudianteRepo.persist(estudiante);
        }

    }

    // BORRAR
    @Auditoria
    public void borrar(Integer id) {
        this.estudianteRepo.deleteById(id);

    }

    public Estudiante buscarPorId(Integer id) {
        return this.estudianteRepo.findById(id);

    }

    public List<Estudiante> buscarTodos() {
        return this.estudianteRepo.listAll();

    }

}
