package uce.edu.ec.pa.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Auditoria;
import uce.edu.ec.pa.infrastructure.repository.AuditoriaRepositoryImpl;

@ApplicationScoped
@Transactional
public class AuditoriaService {

    @Inject
    private AuditoriaRepositoryImpl auditoriaRepo;

    public void guardar(Auditoria auditoria) {
        this.auditoriaRepo.persist(auditoria);

    }

}
