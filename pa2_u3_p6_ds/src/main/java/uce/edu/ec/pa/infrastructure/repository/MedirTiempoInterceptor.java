package uce.edu.ec.pa.infrastructure.repository;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(1)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();
        try {
            return context.proceed();
        } finally {
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución " + context.getMethod().getName() + ": " + (fin - inicio) + " ms");
        }
    }

}
