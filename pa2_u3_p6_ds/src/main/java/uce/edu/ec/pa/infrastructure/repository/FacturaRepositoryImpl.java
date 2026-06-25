package uce.edu.ec.pa.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Factura;

@Transactional
@ApplicationScoped
public class FacturaRepositoryImpl implements PanacheRepositoryBase<Factura, Integer> {

    public Factura buscarPorNumero(String numero) {
        return null;
    }

}
