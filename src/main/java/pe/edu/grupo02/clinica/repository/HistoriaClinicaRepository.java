package pe.edu.grupo02.clinica.repository;

import pe.edu.grupo02.clinica.model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    Optional<HistoriaClinica> findByPacienteId(Long pacienteId);

    long countByDiagnosticoIsNotNull();
}
