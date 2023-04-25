package org.agenda.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agenda.domain.entity.Paciente;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PacienteRepository implements PanacheRepository<Paciente> {

}
