package org.agenda.service;

import lombok.RequiredArgsConstructor;
import org.agenda.domain.entity.Paciente;
import org.agenda.repository.PacienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    @Inject
    private PacienteRepository repository;

    public void create(Paciente paciente){
         repository.persist(paciente);
    }

    public List<Paciente> getAllClients(){
        return repository.listAll();
    }

    public Paciente getById(Long id){
        return repository.findById(id);

    }

    public void deleteClient(Long id){
        repository.deleteById(id);
    }


}
