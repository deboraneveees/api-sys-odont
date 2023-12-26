package br.com.heart.sisodont.controller;

import br.com.heart.sisodont.dto.PacienteDto;
import br.com.heart.sisodont.model.Paciente;
import br.com.heart.sisodont.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PacienteDto> getPaciente(@PathVariable Long id) {

        Paciente paciente = pacienteService.findById(id);

        PacienteDto dto = new PacienteDto();
        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setCpf(paciente.getCpf());
        dto.setEmail(paciente.getEmail());

        return ResponseEntity.ok(dto);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PacienteDto> createPaciente(@RequestBody PacienteDto pacienteDto) {

        Paciente paciente = new Paciente();
        paciente.setId(pacienteDto.getId());
        paciente.setNome(pacienteDto.getNome());
        paciente.setCpf(pacienteDto.getCpf());
        paciente.setEmail(pacienteDto.getEmail());

        Paciente save = pacienteService.save(paciente);

        PacienteDto dto = new PacienteDto();
        dto.setId(save.getId());
        dto.setNome(save.getNome());
        dto.setCpf(save.getCpf());
        dto.setEmail(save.getEmail());

        return ResponseEntity.ok(dto);
    }
}
