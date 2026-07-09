package uce.edu.ec.pa;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.pa.application.service.EstudianteService;
import uce.edu.ec.pa.domain.model.Estudiante;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private EstudianteService estudianteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\nIniciando aplicación\n");

            Estudiante estudiante = new Estudiante();
            estudiante.setApellido("Salazar");
            estudiante.setNombre("David");
            estudiante.setCurso("Programacion Avanzada 2");

            this.estudianteService.guardar(estudiante);

            this.estudianteService.actualizar(1, "Intriago", "Alexander", "Programacion WEB");

            Estudiante estudiante2 = new Estudiante();
            estudiante2.setApellido("apellido");
            estudiante2.setNombre("nombre");
            estudiante2.setCurso("curso");

            this.estudianteService.guardar(estudiante2);

            this.estudianteService.borrar(2);

            System.out.println("\nCerrando aplicación\n");

            return 0;
        }

    }
    
}
