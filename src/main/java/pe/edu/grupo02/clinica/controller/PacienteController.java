package pe.edu.grupo02.clinica.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo02.clinica.model.*;
import pe.edu.grupo02.clinica.repository.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteRepository pacientes;
    private final HistoriaClinicaRepository historias;

    public PacienteController(PacienteRepository p, HistoriaClinicaRepository h) {
        this.pacientes = p;
        this.historias = h;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String q, Model model) {
        model.addAttribute("pacientes", q == null || q.isBlank() ? pacientes.findAll() : pacientes.findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrDniContaining(q, q, q));
        model.addAttribute("q", q);
        return "pacientes/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", pacientes.findById(id).orElseThrow());
        return "pacientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Paciente paciente, BindingResult result) {
        if (result.hasErrors()) return "pacientes/formulario";
        pacientes.save(paciente);
        return "redirect:/pacientes?ok";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Paciente p = pacientes.findById(id).orElseThrow();
        model.addAttribute("paciente", p);
        model.addAttribute("historia", historias.findByPacienteId(id).orElse(null));
        return "pacientes/detalle";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pacientes.deleteById(id);
        return "redirect:/pacientes";
    }
}
