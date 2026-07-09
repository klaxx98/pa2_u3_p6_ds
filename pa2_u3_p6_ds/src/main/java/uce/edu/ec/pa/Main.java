package uce.edu.ec.pa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.ReporteService;
import uce.edu.ec.pa.domain.model.Reporte;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private ReporteService reporteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\nIniciando aplicación\n");

            List<Reporte> lista = new ArrayList<>();

            for (int i = 1; i < 10; i++) {
                Reporte r = new Reporte();
                r.setTitulo("titulo" + i);
                r.setCategoria("categoria" + i);
                r.setTexto("texto" + i);
                r.setAutor("autor" + i);
                r.setFechaCreacion(LocalDateTime.now());
                lista.add(r);

            }

            this.reporteService.guardarListaDeReportes(lista);

            System.out.println("\nCerrando aplicación\n");

            return 0;
        }

    }
    
}
