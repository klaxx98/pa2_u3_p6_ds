package uce.edu.ec.pa.application.service;

import uce.edu.ec.pa.domain.model.Mail;

public class MailServiceTarea implements Runnable {

    //@Inject
    private MailService mailService;

    private Mail mail;

    public MailServiceTarea(MailService mailService, Mail mail) {
        this.mailService = mailService;
        this.mail = mail;
        
    }

    @Override
    public void run() {
        System.out.println(this.mailService);
        this.mailService.guardar(this.mail);

    }

}
