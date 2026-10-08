package pe.edu.grupo02.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.grupo02.clinica.repository.*;

import java.time.LocalDate;

@Controller
public class DashboardController {
    private final PacienteRepository pacientes;
    private final CitaRepository citas;
    private final HistoriaClinicaRepository historias;

    public DashboardController(PacienteRepository pacientes, CitaRepository citas, HistoriaClinicaRepository historias) {
        this.pacientes = pacientes;
        this.citas = citas;
        this.historias = historias;
    }

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model) {
        model.addAttribute("totalPacientes", pacientes.count());
        model.addAttribute("pacientesActivos", pacientes.countByEstado(pe.edu.grupo02.clinica.model.EstadoPaciente.ACTIVO));
        model.addAttribute("citasHoy", citas.countByFecha(LocalDate.now()));
        model.addAttribute("citasProgramadas", citas.countByEstado(pe.edu.grupo02.clinica.model.EstadoCita.PROGRAMADA));
        model.addAttribute("historias", historias.count());
        model.addAttribute("agenda", citas.findByFechaGreaterThanEqualOrderByFechaAscHoraAsc(LocalDate.now()).stream().limit(6).toList());
        return "dashboard";
    }
}
