package uce.edu.ec.pa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.DocumentoService;
import uce.edu.ec.pa.domain.model.Documento;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private DocumentoService documentoService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\nIniciando aplicación\n");

            List<Documento> listaDocumentos = new ArrayList<>();

            for (int i = 1; i < 501; i++) {
                Documento d = new Documento();
                d.setTitulo("titulo: " + i);
                d.setTexto("texto: " + i);
                d.setFirma("" + i);
                d.setFecha(LocalDate.now());
                listaDocumentos.add(d);

            }

            this.documentoService.guardarListaDocumentos(listaDocumentos);

            System.out.println("\nCerrando aplicación\n");

            return 0;
        }

    }
    
}
