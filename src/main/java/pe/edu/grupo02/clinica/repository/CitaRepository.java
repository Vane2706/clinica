package pe.edu.grupo02.clinica.repository;

import pe.edu.grupo02.clinica.model.Cita;
import pe.edu.grupo02.clinica.model.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByFechaOrderByHoraAsc(LocalDate fecha);

    List<Cita> findByFechaGreaterThanEqualOrderByFechaAscHoraAsc(LocalDate fecha);

    long countByFecha(LocalDate fecha);

    long countByEstado(EstadoCita estado);
}
