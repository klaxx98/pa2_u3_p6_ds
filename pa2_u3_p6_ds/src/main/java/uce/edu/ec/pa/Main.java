package uce.edu.ec.pa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.FacturaService;
import uce.edu.ec.pa.application.service.MailService;
import uce.edu.ec.pa.application.service.ReporteService;
import uce.edu.ec.pa.domain.model.Factura;
import uce.edu.ec.pa.domain.model.Mail;
import uce.edu.ec.pa.domain.model.Reporte;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private FacturaService facturaService;

        @Inject
        private MailService mailService;

        @Inject
        private ReporteService reporteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Abriendo proyecto");
            
            /*
            FACTURA
            */
            Factura factura = new Factura();
            factura.setFecha(LocalDate.now());
            factura.setNumero("0001-003");
            factura.setRuc("13235654987");

            this.facturaService.guardar(factura);

            Factura fact = this.facturaService.buscarPorId(1);
            System.out.println(fact.getNumero());

            /*
            MAIL
            */
            Mail m1 = new Mail();
            m1.setCorreoOrigen("correo1@uce.edu.ec");
            m1.setCorreoDestino("correo2@uce.edu.ec");
            m1.setAsunto("Locura");
            m1.setTexto("Buenas noches mis panas, Ecuador le ganó 2-1 a Alemania");
            m1.setFecha(LocalDate.now());

            this.mailService.guardar(m1);

            System.out.println(this.mailService.buscarPorId(1).getTexto());

            /*
            REPORTE
            */
            Reporte r1 = new Reporte();
            r1.setTitulo("Reporte de contabilidad");
            r1.setCategoria("ENVIADO");
            r1.setTexto("El reporte de contabilidad del departamento B1 indica que no hay errores contables");
            r1.setAutor("Lcdo. Salas");
            r1.setFechaCreacion(LocalDateTime.now());

            this.reporteService.guardar(r1);

            System.out.println(this.reporteService.buscarPorId(1).getTitulo());

            return 0;
        }

    }
    
}
