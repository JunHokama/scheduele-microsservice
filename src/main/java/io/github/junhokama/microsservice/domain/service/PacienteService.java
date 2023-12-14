package io.github.junhokama.microsservice.domain.service;

import io.github.junhokama.microsservice.domain.entity.Paciente;
import io.github.junhokama.microsservice.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // todos os métodos serão transacionais
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente save(Paciente paciente){
        return repository.save(paciente);
    }

    public List<Paciente> listAll(){
        return repository.findAll();
    }

    public Optional<Paciente> findById(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
