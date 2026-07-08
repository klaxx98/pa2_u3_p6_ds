package uce.edu.ec.pa.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante extends PanacheEntityBase {

    @Id
    @Column(name="estu_id")
    @SequenceGenerator(name="seq_estudiante_generator", sequenceName="seq_estudiante", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="seq_estudiante_generator")
    private Integer id;

    @Column(name="estu_apellido")
    private String apellido;

    @Column(name="estu_nombre")
    private String nombre;

    @Column(name="estu_curso")
    private String curso;

    public Estudiante(Integer id, String apellido, String nombre, String curso) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.curso = curso;
    }

    public Estudiante() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getApellido() {
        return apellido;

    }

    public void setApellido(String apellido) {
        this.apellido = apellido;

    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getCurso() {
        return curso;

    }

    public void setCurso(String curso) {
        this.curso = curso;

    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", curso=" + curso + "]";
    }
    
}
