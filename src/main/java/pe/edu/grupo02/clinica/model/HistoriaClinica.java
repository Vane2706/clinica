package pe.edu.grupo02.clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historias_clinicas")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Paciente paciente;

    @NotBlank
    @Size(max = 100)
    private String motivoConsulta;
    @Size(max = 3000)
    @Column(length = 3000)
    private String antecedentes;
    @Size(max = 3000)
    @Column(length = 3000)
    private String diagnostico;
    @Size(max = 3000)
    @Column(length = 3000)
    private String tratamiento;
    @Size(max = 2000)
    @Column(length = 2000)
    private String observaciones;
    private LocalDateTime fechaActualizacion;

    @PrePersist
    @PreUpdate
    public void actualizarFecha() {
        fechaActualizacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente v) {
        this.paciente = v;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String v) {
        this.motivoConsulta = v;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String v) {
        this.antecedentes = v;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String v) {
        this.diagnostico = v;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String v) {
        this.tratamiento = v;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String v) {
        this.observaciones = v;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime v) {
        this.fechaActualizacion = v;
    }
}
