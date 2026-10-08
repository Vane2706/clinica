package pe.edu.grupo02.clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 80)
    private String nombres;
    @NotBlank
    @Size(max = 80)
    private String apellidos;
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String dni;
    @NotNull
    private LocalDate fechaNacimiento;
    @Size(max = 20)
    private String telefono;
    @Email
    @Size(max = 120)
    private String correo;
    @Size(max = 180)
    private String direccion;
    @Size(max = 40)
    private String sexo;
    @Enumerated(EnumType.STRING)
    private EstadoPaciente estado = EstadoPaciente.ACTIVO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String v) {
        this.nombres = v;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String v) {
        this.apellidos = v;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String v) {
        this.dni = v;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate v) {
        this.fechaNacimiento = v;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String v) {
        this.telefono = v;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String v) {
        this.correo = v;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String v) {
        this.direccion = v;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String v) {
        this.sexo = v;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    public void setEstado(EstadoPaciente v) {
        this.estado = v;
    }

    @Transient
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }
}
