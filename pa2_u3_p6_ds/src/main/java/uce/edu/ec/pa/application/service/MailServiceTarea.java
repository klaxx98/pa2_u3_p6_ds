package uce.edu.ec.pa.application.service;

import jakarta.enterprise.context.Dependent;
import uce.edu.ec.pa.domain.model.Mail;

@Dependent
public class MailServiceTarea implements Runnable {

    private MailService mailService;

    private Mail mail;

    public void setMail(Mail mail) {
        this.mail = mail;

    }

    @Override
    public void run() {
        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo MailServiceTarea: "+hilo);
        this.mailService.guardar(this.mail);

    }

}
