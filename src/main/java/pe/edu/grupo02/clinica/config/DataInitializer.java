package pe.edu.grupo02.clinica.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.grupo02.clinica.model.*;
import pe.edu.grupo02.clinica.repository.*;

import java.time.*;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner init(PacienteRepository pacientes, HistoriaClinicaRepository historias, CitaRepository citas) {
        return args -> {
            if (pacientes.count() > 0) return;

            Paciente p1 = new Paciente();
            p1.setNombres("María Fernanda");
            p1.setApellidos("García Torres");
            p1.setDni("74851236");
            p1.setFechaNacimiento(LocalDate.of(1997, 4, 18));
            p1.setTelefono("987654321");
            p1.setCorreo("maria.garcia@email.com");
            p1.setSexo("Femenino");
            pacientes.save(p1);

            Paciente p2 = new Paciente();
            p2.setNombres("Carlos Alberto");
            p2.setApellidos("Ramírez Díaz");
            p2.setDni("70654321");
            p2.setFechaNacimiento(LocalDate.of(1989, 9, 2));
            p2.setTelefono("976321456");
            p2.setCorreo("carlos.ramirez@email.com");
            p2.setSexo("Masculino");
            pacientes.save(p2);

            Paciente p3 = new Paciente();
            p3.setNombres("Sofía");
            p3.setApellidos("Vásquez Rojas");
            p3.setDni("75987412");
            p3.setFechaNacimiento(LocalDate.of(2002, 12, 11));
            p3.setTelefono("965478123");
            p3.setCorreo("sofia.vasquez@email.com");
            p3.setSexo("Femenino");
            pacientes.save(p3);

            HistoriaClinica h = new HistoriaClinica();
            h.setPaciente(p1);
            h.setMotivoConsulta("Control médico general");
            h.setAntecedentes("Alergia estacional. Sin antecedentes quirúrgicos relevantes.");
            h.setDiagnostico("Rinitis alérgica controlada.");
            h.setTratamiento("Antihistamínico según indicación médica.");
            h.setObservaciones("Se recomienda control en 3 meses.");
            historias.save(h);

            Cita c1 = new Cita();
            c1.setPaciente(p1);
            c1.setMedico("Dra. Ana Salazar");
            c1.setEspecialidad("Medicina General");
            c1.setFecha(LocalDate.now());
            c1.setHora(LocalTime.of(9, 30));
            c1.setMotivo("Control general");
            citas.save(c1);

            Cita c2 = new Cita();
            c2.setPaciente(p2);
            c2.setMedico("Dr. Luis Mendoza");
            c2.setEspecialidad("Cardiología");
            c2.setFecha(LocalDate.now().plusDays(1));
            c2.setHora(LocalTime.of(11, 0));
            c2.setMotivo("Evaluación cardiovascular");
            citas.save(c2);

            Cita c3 = new Cita();
            c3.setPaciente(p3);
            c3.setMedico("Dra. Carla Ríos");
            c3.setEspecialidad("Dermatología");
            c3.setFecha(LocalDate.now().plusDays(2));
            c3.setHora(LocalTime.of(15, 30));
            c3.setMotivo("Consulta dermatológica");
            citas.save(c3);
        };
    }
}
