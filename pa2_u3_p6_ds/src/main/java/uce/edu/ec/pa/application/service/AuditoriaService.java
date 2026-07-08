package uce.edu.ec.pa.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Auditoria;
import uce.edu.ec.pa.infrastructure.repository.AuditoriaRepositoryImpl;
import uce.edu.ec.pa.infrastructure.repository.MedirTiempo;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    @Inject
    private AuditoriaRepositoryImpl auditoriaRepo;

    @MedirTiempo
    public void guardar(Auditoria auditoria) {
        this.auditoriaRepo.persist(auditoria);

    }

}
