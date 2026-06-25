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
@Table(name="factura")
public class Factura extends PanacheEntityBase {

    @Id
    @Column(name="fact_id")
    @SequenceGenerator(name="seq_factura_generator", sequenceName="seq_factura", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="seq_factura_generator")
    private Integer id;

    @Column(name="fact_fecha")
    private LocalDate fecha;

    @Column(name="fact_numero")
    private String numero;

    @Column(name="fact_ruc")
    private String ruc;

    public Factura(Integer id, LocalDate fecha, String numero, String ruc) {
        this.fecha = fecha;
        this.id = id;
        this.numero = numero;
        this.ruc = ruc;
    }

    public Factura() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura{");
        sb.append("id=").append(id);
        sb.append(", fecha=").append(fecha);
        sb.append(", numero=").append(numero);
        sb.append(", ruc=").append(ruc);
        sb.append('}');
        return sb.toString();
    }

}
