package uce.edu.ec.pa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.FacturaService;
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

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\nIniciando aplicación\n");

            Factura f = new Factura();
            f.setFecha(LocalDate.now());
            f.setNumero("1111-2222");
            f.setRuc("01236544563210");

            Mail m = new Mail();
            m.setCorreoOrigen("origin@mail.com");
            m.setCorreoDestino("destiny@mail.com");
            m.setAsunto("Factura de compra");
            m.setTexto("Gracias por su visita! Su orden de compra es por el valor de $15");
            m.setFecha(LocalDate.now());

            Reporte r = new Reporte();
            r.setTitulo("Reporte de venta");
            r.setCategoria("VENTAS");
            r.setTexto("Venta registrada por el valor de $15");
            r.setAutor("RV. David");
            r.setFechaCreacion(LocalDateTime.now());

            this.facturaService.generarFacturaReporteMail(f, m, r);

            System.out.println("\nCerrando aplicación\n");

            return 0;
        }

    }
    
}
