package uce.edu.ec.pa.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="documento")
public class Documento extends PanacheEntityBase {

    @Id
    @Column(name="docu_id")
    @SequenceGenerator(name="seq_documento_generator", sequenceName="seq_documento", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_documento_generator")
    private Integer id;

    @Column(name="docu_titulo")
    private String titulo;

    @Column(name="docu_texto")
    private String texto;

    @Column(name="docu_firma")
    private String firma;

    @Column(name="docu_fecha")
    private LocalDate fecha;

    public Documento(LocalDate fecha, String firma, Integer id, String texto, String titulo) {
        this.fecha = fecha;
        this.firma = firma;
        this.id = id;
        this.texto = texto;
        this.titulo = titulo;
    }

    public Documento() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getTitulo() {
        return titulo;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }

    public String getTexto() {
        return texto;

    }

    public void setTexto(String texto) {
        this.texto = texto;

    }

    public String getFirma() {
        return firma;

    }

    public void setFirma(String firma) {
        this.firma = firma;

    }

    public LocalDate getFecha() {
        return fecha;

    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;

    }

    @Override
    public String toString() {
        return "Documento [id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", firma=" + firma + ", fecha="
                + fecha + "]";
    }

}
