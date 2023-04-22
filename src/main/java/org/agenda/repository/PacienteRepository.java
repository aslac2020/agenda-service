package org.agenda.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agenda.domain.entity.Paciente;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PacienteRepository implements PanacheRepository<Paciente> {
}
