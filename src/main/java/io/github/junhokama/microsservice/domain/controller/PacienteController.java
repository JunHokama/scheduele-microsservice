package io.github.junhokama.microsservice.domain.controller;

import io.github.junhokama.microsservice.domain.entity.Paciente;
import io.github.junhokama.microsservice.domain.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Paciente> salvar (@RequestBody Paciente paciente){
        Paciente savedPaciente = service.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaciente);

        // Outro método possíveo: return ResponseEntity.ok(savedPaciente);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> listAll(){
        List<Paciente> pacientes = service.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
}
