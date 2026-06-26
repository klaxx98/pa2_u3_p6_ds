package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Mail;
import uce.edu.ec.pa.infrastructure.repository.MailRepositoryImpl;

@ApplicationScoped
@Transactional
public class MailService {

    @Inject
    private MailRepositoryImpl mailRepo;

    public void guardar(Mail mail) {
        mail.persist();

    }

    public Mail buscarPorId(Integer id) {
        return this.mailRepo.findById(id);

    }

    public List<Mail> buscarTodos() {
        return this.mailRepo.listAll();
        
    }

}
