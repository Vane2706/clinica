package pe.edu.grupo02.clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private Paciente paciente;
    @NotBlank
    @Size(max = 100)
    private String medico;
    @NotBlank
    @Size(max = 80)
    private String especialidad;
    @NotNull
    private LocalDate fecha;
    @NotNull
    private LocalTime hora;
    @Size(max = 300)
    private String motivo;
    @Enumerated(EnumType.STRING)
    private EstadoCita estado = EstadoCita.PROGRAMADA;

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

    public String getMedico() {
        return medico;
    }

    public void setMedico(String v) {
        this.medico = v;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String v) {
        this.especialidad = v;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate v) {
        this.fecha = v;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime v) {
        this.hora = v;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String v) {
        this.motivo = v;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita v) {
        this.estado = v;
    }
}
