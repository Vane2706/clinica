package pe.edu.grupo02.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo02.clinica.model.*;
import pe.edu.grupo02.clinica.repository.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/citas")
public class CitaController {
    private final CitaRepository citas;
    private final PacienteRepository pacientes;

    public CitaController(CitaRepository c, PacienteRepository p) {
        this.citas = c;
        this.pacientes = p;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String fecha, Model model) {
        LocalDate f = (fecha == null || fecha.isBlank()) ? LocalDate.now() : LocalDate.parse(fecha);
        model.addAttribute("citas", citas.findByFechaOrderByHoraAsc(f));
        model.addAttribute("fecha", f);
        return "citas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("pacientes", pacientes.findAll());
        return "citas/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cita", citas.findById(id).orElseThrow());
        model.addAttribute("pacientes", pacientes.findAll());
        return "citas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cita cita) {
        citas.save(cita);
        return "redirect:/citas";
    }

    @PostMapping("/estado/{id}")
    public String estado(@PathVariable Long id, @RequestParam EstadoCita estado) {
        Cita c = citas.findById(id).orElseThrow();
        c.setEstado(estado);
        citas.save(c);
        return "redirect:/citas?fecha=" + c.getFecha();
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        citas.deleteById(id);
        return "redirect:/citas";
    }
}
