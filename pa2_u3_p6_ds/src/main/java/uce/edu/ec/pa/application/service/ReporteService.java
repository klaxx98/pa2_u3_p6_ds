package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Reporte;
import uce.edu.ec.pa.infrastructure.repository.MedirTiempo;
import uce.edu.ec.pa.infrastructure.repository.ReporteRepositoryImpl;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepo;

    @MedirTiempo
    public void guardar(Reporte reporte) {
        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo ReporteService: "+hilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        reporte.persist();

    }

    @MedirTiempo
    public Reporte buscarPorId(Integer id) {
        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo buscarPorIdReporte: "+hilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        return this.reporteRepo.findById(id);
        
    }

    public List<Reporte> buscarTodos() {
        return this.reporteRepo.listAll();
        
    }

}
