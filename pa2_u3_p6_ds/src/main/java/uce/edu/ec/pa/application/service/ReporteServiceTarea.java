package uce.edu.ec.pa.application.service;

import uce.edu.ec.pa.domain.model.Reporte;

public class ReporteServiceTarea implements Runnable {

    //@Inject
    private ReporteService reporteService;

    private Reporte reporte;

    public ReporteServiceTarea(ReporteService reporteService, Reporte reporte) {
        this.reporteService = reporteService;
        this.reporte = reporte;

    }

    @Override
    public void run() {
        System.out.println(this.reporteService);
        this.reporteService.guardar(this.reporte);

    }

}
