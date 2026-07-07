package uce.edu.ec.pa.application.service;

import jakarta.enterprise.context.Dependent;
import uce.edu.ec.pa.domain.model.Reporte;

@Dependent
public class ReporteServiceTarea implements Runnable {

    private ReporteService reporteService;

    private Reporte reporte;

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;

    }

    @Override
    public void run() {
        String hilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo ReporteServiceTarea: "+hilo);
        this.reporteService.guardar(this.reporte);

    }

}
