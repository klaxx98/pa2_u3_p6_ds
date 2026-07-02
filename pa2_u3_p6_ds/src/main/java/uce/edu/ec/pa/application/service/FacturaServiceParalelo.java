package uce.edu.ec.pa.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Factura;
import uce.edu.ec.pa.domain.model.Mail;
import uce.edu.ec.pa.domain.model.Reporte;
import uce.edu.ec.pa.infrastructure.repository.FacturaRepositoryImpl;
import uce.edu.ec.pa.infrastructure.repository.MedirTiempo;

@ApplicationScoped
@Transactional
public class FacturaServiceParalelo {

    @Inject
    private FacturaRepositoryImpl facturaRepo;

    @Inject
    private ReporteService reporteService;

    @Inject
    private MailService mailService;

    @MedirTiempo
    public void guardar(Factura factura) throws Exception {

        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo FacturaService: "+hilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.facturaRepo.persist(factura);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Reporte reporte = new Reporte();
        reporte.setTitulo("Reporte Factura 1");
        reporte.setCategoria("Facturación");
        reporte.setTexto("Texto autogenerado del reporte de la factura");
        reporte.setAutor("JJ");
        reporte.setFechaCreacion(LocalDateTime.now());
        ReporteServiceTarea reporteServiceTarea = new ReporteServiceTarea(reporteService, reporte);
        executorService.submit(reporteServiceTarea);

        Mail mail = new Mail();
        mail.setCorreoOrigen("jj@uce.com");
        mail.setCorreoDestino("sñ@gmail.com");
        mail.setAsunto("Factura");
        mail.setTexto("Se ha generado la factura de su compra");
        mail.setFecha(LocalDate.now());
        MailServiceTarea mailServiceTarea = new MailServiceTarea(mailService, mail);
        executorService.submit(mailServiceTarea);

        // Cerrar el proceso de ejecucion
        executorService.shutdown();
        Thread.sleep(Long.valueOf(100));

    }

}
