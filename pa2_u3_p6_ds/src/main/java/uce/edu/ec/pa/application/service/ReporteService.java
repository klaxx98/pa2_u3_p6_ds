package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Reporte;
import uce.edu.ec.pa.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepo;

    public void guardar(Reporte reporte) {
        reporte.persist();

    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepo.findById(id);
        
    }

    public List<Reporte> buscarTodos() {
        return this.reporteRepo.listAll();
        
    }

}
