package uce.edu.ec.pa;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.FacturaService;
import uce.edu.ec.pa.domain.model.Factura;

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

            System.out.println("Abriendo proyecto");

            Factura factura = new Factura();
            factura.setFecha(LocalDate.now());
            factura.setNumero("0001-003");
            factura.setRuc("13235654987");

            this.facturaService.guardar(factura);

            Factura fact = this.facturaService.buscarPorId(1);
            System.out.println(fact.getNumero());

            return 0;
        }

    }
    
}

