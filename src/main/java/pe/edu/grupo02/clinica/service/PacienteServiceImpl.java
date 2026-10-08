package pe.edu.grupo02.clinica.service;

import org.springframework.stereotype.Service;
import pe.edu.grupo02.clinica.model.Paciente;
import pe.edu.grupo02.clinica.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository repo;

    public PacienteServiceImpl(PacienteRepository repo) {
        this.repo = repo;
    }

    public List<Paciente> listar(String q) {
        return q == null || q.isBlank() ? repo.findAll() : repo.findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrDniContaining(q, q, q);
    }

    public Paciente obtener(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Paciente guardar(Paciente p) {
        return repo.save(p);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
