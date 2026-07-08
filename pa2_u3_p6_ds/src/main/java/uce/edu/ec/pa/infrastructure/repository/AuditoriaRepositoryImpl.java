package uce.edu.ec.pa.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Auditoria;

@ApplicationScoped
@Transactional
public class AuditoriaRepositoryImpl implements PanacheRepositoryBase<Auditoria, Integer> {

}
