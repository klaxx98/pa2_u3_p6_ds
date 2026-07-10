package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Documento;
import uce.edu.ec.pa.infrastructure.repository.Auditoria;
import uce.edu.ec.pa.infrastructure.repository.DocumentoRepositoryImpl;

@ApplicationScoped
@Transactional
public class DocumentoService {

    @Inject
    private DocumentoRepositoryImpl documentoRepo;

    public void guardar(Documento documento) {
        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo DocumentoService: " + hilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.documentoRepo.persist(documento);

    }

    @Auditoria
    public void guardarListaDocumentos(List<Documento> lista) {
        for (Documento d : lista) {
            this.guardar(d);

        }

    }

}
