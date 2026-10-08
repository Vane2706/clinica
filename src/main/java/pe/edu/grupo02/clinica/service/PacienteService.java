package pe.edu.grupo02.clinica.service;

import pe.edu.grupo02.clinica.model.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> listar(String q);

    Paciente obtener(Long id);

    Paciente guardar(Paciente p);

    void eliminar(Long id);
}
