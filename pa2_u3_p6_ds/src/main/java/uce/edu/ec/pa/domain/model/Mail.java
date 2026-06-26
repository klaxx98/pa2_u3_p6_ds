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
@Table(name="mail")
public class Mail extends PanacheEntityBase {

    @Id
    @Column(name="mail_id")
    @SequenceGenerator(name="seq_mail_generator", sequenceName="seq_mail", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_mail_generator")
    private Integer id;

    @Column(name="mail_correo_origen")
    private String correoOrigen;

    @Column(name="mail_correo_destino")
    private String correoDestino;

    @Column(name="mail_asunto")
    private String asunto;

    @Column(name="mail_texto")
    private String texto;

    @Column(name="mail_fecha")
    private LocalDate fecha;

    public Mail(Integer id, String correoOrigen, String correoDestino, String asunto, String texto, LocalDate fecha) {
        this.id = id;
        this.correoOrigen = correoOrigen;
        this.correoDestino = correoDestino;
        this.asunto = asunto;
        this.texto = texto;
        this.fecha = fecha;

    }

    public Mail() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getCorreoOrigen() {
        return correoOrigen;

    }

    public void setCorreoOrigen(String correoOrigen) {
        this.correoOrigen = correoOrigen;

    }

    public String getCorreoDestino() {
        return correoDestino;

    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;

    }

    public String getAsunto() {
        return asunto;

    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;

    }

    public String getTexto() {
        return texto;

    }

    public void setTexto(String texto) {
        this.texto = texto;

    }

    public LocalDate getFecha() {
        return fecha;

    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mail{");
        sb.append("id=").append(id);
        sb.append(", correoOrigen=").append(correoOrigen);
        sb.append(", correoDestino=").append(correoDestino);
        sb.append(", asunto=").append(asunto);
        sb.append(", texto=").append(texto);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
        
    }

}
