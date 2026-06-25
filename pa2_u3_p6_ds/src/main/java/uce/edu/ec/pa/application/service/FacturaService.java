package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Factura;
import uce.edu.ec.pa.infrastructure.repository.FacturaRepositoryImpl;

@ApplicationScoped
@Transactional
public class FacturaService {

    @Inject
    private FacturaRepositoryImpl facturaRepo;

    public void guardar(Factura factura) {
        factura.persist();
        //this.facturaRepo.persist(factura);

    }

    public Factura buscarPorId(Integer id) {
        return this.facturaRepo.findById(id);

    }

    public List<Factura> buscarTodos() {
        return this.facturaRepo.listAll();
    }

}
