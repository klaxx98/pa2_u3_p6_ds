package uce.edu.ec.pa.domain.model;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="reporte")
public class Reporte extends PanacheEntityBase {

    @Id
    @Column(name="repo_id")
    @SequenceGenerator(name="seq_reporte_generator", sequenceName="seq_reporte", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_reporte_generator")
    private Integer id;

    @Column(name="repo_titulo")
    private String titulo;

    @Column(name="repo_categoria")
    private String categoria;

    @Column(name="repo_texto")
    private String texto;

    @Column(name="repo_autor")
    private String autor;

    @Column(name="repo_fecha_creacion")
    private LocalDateTime fechaCreacion;

    public Reporte(Integer id, String titulo, String categoria, String texto, String autor,
            LocalDateTime fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.texto = texto;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;

    }

    public Reporte() {

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

    public String getCategoria() {
        return categoria;

    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;

    }

    public String getTexto() {
        return texto;

    }

    public void setTexto(String texto) {
        this.texto = texto;

    }

    public String getAutor() {
        return autor;

    }

    public void setAutor(String autor) {
        this.autor = autor;

    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;

    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        
    }

    @Override
    public String toString() {
        return "Reporte [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", texto=" + texto + ", autor="
                + autor + ", fechaCreacion=" + fechaCreacion + "]";
    }

}
