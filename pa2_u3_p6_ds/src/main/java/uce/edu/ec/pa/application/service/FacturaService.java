package uce.edu.ec.pa.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
public class FacturaService {

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
        this.reporteService.guardar(reporte);

        Mail mail = new Mail();
        mail.setCorreoOrigen("jj@uce.com");
        mail.setCorreoDestino("sñ@gmail.com");
        mail.setAsunto("Factura");
        mail.setTexto("Se ha generado la factura de su compra");
        mail.setFecha(LocalDate.now());
        mailService.guardar(mail);

    }

    public Factura buscarPorId(Integer id) {
        return this.facturaRepo.findById(id);

    }

    public List<Factura> buscarTodos() {
        return this.facturaRepo.listAll();
    }

}
