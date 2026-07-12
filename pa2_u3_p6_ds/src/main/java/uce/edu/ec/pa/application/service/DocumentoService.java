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

        this.documentoRepo.persist(documento);

    }

    // SECUENCIAL HILO PRINCIPAL
    @Auditoria
    public void guardarListaDocumentos(List<Documento> lista) {
        for (Documento d : lista) {
            this.guardar(d);

        }

    }

    // CONCURRENTE FORK-JOIN
    @Auditoria
    public void guardarListaDocumentosParalelo(List<Documento> lista) {
        lista.parallelStream().forEach(doc -> {
            this.guardar(doc);

        });

    }

}
