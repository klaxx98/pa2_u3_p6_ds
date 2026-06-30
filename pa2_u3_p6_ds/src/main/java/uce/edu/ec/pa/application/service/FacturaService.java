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

    @MedirTiempo
    public void guardarFactura(Factura factura) {
        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo FacturaService: "+hilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        this.facturaRepo.persist(factura);

    }

    // Método con 4 - 5 métodos internos
    @MedirTiempo
    public void generarFacturaReporteMail(Factura factura, Mail mail, Reporte reporte) {

        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo FacturaReporteMail: " + hilo);
        System.out.println("ID del hilo: " + Thread.currentThread().threadId());

        System.out.println("\nGenerando factura de venta");

        this.guardarFactura(factura);
        this.mailService.guardar(mail);
        this.reporteService.guardar(reporte);

        System.out.println("\nGenerando reporte de venta realizada con Id: " + reporte.getId());
        System.out.println(this.reporteService.buscarPorId(reporte.getId()));

        System.out.println("Enviando factura electrónica al correo: " + mail.getCorreoDestino());
        System.out.println(this.mailService.buscarPorId(mail.getId()));

    }

    public Factura buscarPorId(Integer id) {
        return this.facturaRepo.findById(id);

    }

    public List<Factura> buscarTodos() {
        return this.facturaRepo.listAll();
    }

}
