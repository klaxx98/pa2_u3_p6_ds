package uce.edu.ec.pa.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import uce.edu.ec.pa.domain.model.Factura;
import uce.edu.ec.pa.domain.model.Mail;
import uce.edu.ec.pa.domain.model.Reporte;
import uce.edu.ec.pa.infrastructure.repository.FacturaRepositoryImpl;
import uce.edu.ec.pa.infrastructure.repository.MedirTiempo;

@Dependent
public class FacturaServiceCompletableFuture {

    @Inject
    private FacturaRepositoryImpl facturaRepo;

    @Inject
    private ReporteService reporteService;

    @Inject
    private MailService mailService;

    @MedirTiempo
    public void guardar(Factura factura) {

        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo FacturaService: "+hilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.facturaRepo.persist(factura);

        Reporte reporte = new Reporte();
        reporte.setTitulo("Reporte Factura 1");
        reporte.setCategoria("Facturación");
        reporte.setTexto("Texto autogenerado del reporte de la factura");
        reporte.setAutor("JJ");
        reporte.setFechaCreacion(LocalDateTime.now());
        CompletableFuture<Void> completableReporte = CompletableFuture.runAsync(()->this.reporteService.guardar(reporte));

        Mail mail = new Mail();
        mail.setCorreoOrigen("jj@uce.com");
        mail.setCorreoDestino("sñ@gmail.com");
        mail.setAsunto("Factura");
        mail.setTexto("Se ha generado la factura de su compra");
        mail.setFecha(LocalDate.now());
        CompletableFuture<Void> completableMail = CompletableFuture.runAsync(()->mailService.guardar(mail));
        
        // Espera a que los hilos asignados terminen su ejecución
        CompletableFuture.allOf(completableReporte, completableMail).join();

    }

}
