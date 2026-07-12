package uce.edu.ec.pa.infrastructure.repository;

import java.time.LocalDateTime;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.ec.pa.application.service.AuditoriaService;
import uce.edu.ec.pa.domain.model.Auditoria;

@uce.edu.ec.pa.infrastructure.repository.Auditoria
@Interceptor
@Priority(1)
@Dependent
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService auditoriaService;

    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();

        try {
            return context.proceed();
        } finally {
            long fin = System.currentTimeMillis();
            
            Auditoria auditoria = new Auditoria();
            auditoria.setNombreMetodo(context.getMethod().getName());
            auditoria.setArgumentos(context.getMethod().getName());
            auditoria.setFechaHoraEjecucion(LocalDateTime.now());
            long total = fin - inicio;
            auditoria.setTiempoEjecucionMs(total);

            this.auditoriaService.guardar(auditoria);
            System.out.println(auditoria.toString());

        }

    }

}
