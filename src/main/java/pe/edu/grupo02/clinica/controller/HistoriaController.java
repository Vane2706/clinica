package pe.edu.grupo02.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo02.clinica.model.*;
import pe.edu.grupo02.clinica.repository.*;

@Controller
@RequestMapping("/historias")
public class HistoriaController {
    private final HistoriaClinicaRepository historias;
    private final PacienteRepository pacientes;

    public HistoriaController(HistoriaClinicaRepository h, PacienteRepository p) {
        this.historias = h;
        this.pacientes = p;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("historias", historias.findAll());
        return "historias/lista";
    }

    @GetMapping("/nueva/{pacienteId}")
    public String nueva(@PathVariable Long pacienteId, Model model) {
        HistoriaClinica h = historias.findByPacienteId(pacienteId).orElseGet(HistoriaClinica::new);
        h.setPaciente(pacientes.findById(pacienteId).orElseThrow());
        model.addAttribute("historia", h);
        return "historias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute HistoriaClinica historia) {
        historias.save(historia);
        return "redirect:/historias";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        model.addAttribute("historia", historias.findById(id).orElseThrow());
        return "historias/detalle";
    }
}
