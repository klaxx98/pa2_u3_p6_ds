package uce.edu.ec.pa;

import java.time.LocalDate;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.FacturaServiceCompletableFuture;
import uce.edu.ec.pa.domain.model.Factura;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private FacturaServiceCompletableFuture facturaServiceCompletableFuture;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\nIniciando aplicación\n");

            Factura f = new Factura();
            f.setFecha(LocalDate.now());
            f.setNumero("1111-2222");
            f.setRuc("01236544563210");

            //this.FacturaServiceParalelo.guardar(f);
            this.facturaServiceCompletableFuture.guardar(f);

            System.out.println("\nCerrando aplicación\n");

            return 0;
        }

    }
    
}
