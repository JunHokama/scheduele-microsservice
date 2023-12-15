package io.github.junhokama.microsservice.domain.service;

import io.github.junhokama.microsservice.domain.entity.Paciente;
import io.github.junhokama.microsservice.domain.repository.PacienteRepository;
import io.github.junhokama.microsservice.exception.BusinessException;
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
        boolean existeCpf = false;
        boolean existeEmail = false;

        Optional<Paciente> optPacienteCpf = repository.findByCpf(paciente.getCpf());

        if(optPacienteCpf.isPresent()){
            if(!optPacienteCpf.get().getId().equals(paciente.getId())){
                existeCpf = true;
            }
        }
        if(existeCpf) throw new BusinessException("CPF já cadastrado");

        Optional<Paciente> optPacienteEmail = repository.findByEmail(paciente.getEmail());

        if (optPacienteEmail.isPresent() && !optPacienteEmail.get().getId().equals(paciente.getId())) {
            existeEmail = true;
        }

        if (existeEmail) {
            throw new BusinessException("E-mail já cadastrado");
        }

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
