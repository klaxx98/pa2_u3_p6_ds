package uce.edu.ec.pa.infrastructure.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ArchivoInterceptor
@Interceptor
@Priority(1)
@Dependent
public class ArchivoInterceptorInterceptor {

    @AroundInvoke
    public Object archivo(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();
        try {
            return context.proceed();
        } finally {
            try {
                FileWriter escritor = new FileWriter("archivoInterceptor.txt");
            
                long fin = System.currentTimeMillis();
                escritor.write("Nombre del método: " + context.getMethod().getName().toUpperCase() + "\n");
                escritor.write("Argumentos del método: " + Arrays.toString(context.getParameters()) + "\n");
                escritor.write("Fecha y hora de ejecución: " + LocalDateTime.now().toString() + "\n");
                long total = fin - inicio;
                escritor.write("Tiempo de ejecución: " + total + " ms");

                escritor.close();
                System.out.println("Archivo creado y escrito con éxito.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
