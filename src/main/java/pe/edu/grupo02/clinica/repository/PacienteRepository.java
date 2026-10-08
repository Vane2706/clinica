package pe.edu.grupo02.clinica.repository;

import pe.edu.grupo02.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrDniContaining(String n, String a, String d);

    long countByEstado(pe.edu.grupo02.clinica.model.EstadoPaciente estado);
}
