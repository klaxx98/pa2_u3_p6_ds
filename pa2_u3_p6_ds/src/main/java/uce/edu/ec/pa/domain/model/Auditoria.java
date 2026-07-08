package uce.edu.ec.pa.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="auditoria")
public class Auditoria {

    @Id
    @Column(name="audi_id")
    @SequenceGenerator(name="seq_auditoria_generator", sequenceName="seq_auditoria", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="seq_auditoria_generator")
    private Integer id;

    @Column(name="audi_nombre_metodo")
    private String nombreMetodo;

    @Column(name="audi_argumentos")
    private String argumentos;

    @Column(name="audi_fecha_hora_ejecucion")
    private LocalDateTime fechaHoraEjecucion;

    @Column(name="audi_tiempo_ejecucion_ms")
    private Long tiempoEjecucionMs;

    public Auditoria(Integer id, String nombreMetodo, String argumentos, LocalDateTime fechaHoraEjecucion,
            Long tiempoEjecucionMs) {
        this.id = id;
        this.nombreMetodo = nombreMetodo;
        this.argumentos = argumentos;
        this.fechaHoraEjecucion = fechaHoraEjecucion;
        this.tiempoEjecucionMs = tiempoEjecucionMs;

    }

    public Auditoria() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getNombreMetodo() {
        return nombreMetodo;

    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;

    }

    public String getArgumentos() {
        return argumentos;

    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;

    }

    public LocalDateTime getFechaHoraEjecucion() {
        return fechaHoraEjecucion;

    }

    public void setFechaHoraEjecucion(LocalDateTime fechaHoraEjecucion) {
        this.fechaHoraEjecucion = fechaHoraEjecucion;

    }

    public Long getTiempoEjecucionMs() {
        return tiempoEjecucionMs;

    }

    public void setTiempoEjecucionMs(Long tiempoEjecucionMs) {
        this.tiempoEjecucionMs = tiempoEjecucionMs;

    }

    @Override
    public String toString() {
        return "Auditoria [id=" + id + ", nombreMetodo=" + nombreMetodo + ", argumentos=" + argumentos
                + ", fechaHoraEjecucion=" + fechaHoraEjecucion + ", tiempoEjecucionMs=" + tiempoEjecucionMs + "]";
                
    }

}
