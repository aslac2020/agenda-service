package org.agenda;

import org.agenda.domain.entity.Paciente;
import org.agenda.service.PacienteService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/agenda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendaResource {

    @Inject
    PacienteService service;

    @GET
    public Response getAllPacients(){
        List<Paciente> pacients = service.getAllPacients();
       return Response.ok(pacients).status(200).build();
    }

    @POST
    @Transactional
    public Response createPacients(Paciente paciente){
        List<Paciente> lisPacients = service.getAllPacients();
        String cpf = paciente.getCpf();
        lisPacients.forEach(pacients -> {
            if(pacients.getCpf() == cpf){
                Response.status(404).entity("Cpf já cadastrado no banco, favor informar outro cpf").build();
            }
        });

        return Response.ok(paciente).status(201).build();
    }

    @GET
    @Path("{id}")
    public Response getPatientById(@PathParam("id") Long id){
        Paciente paciente = this.service.getById(id);
        if(paciente == null){
            return  Response.status(404).entity("Usuario não existe no banco").build();
        }
        return Response.ok(paciente).status(200).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePatient(@PathParam("id") Long id){
        Paciente paciente = this.service.getById(id);
        if(paciente == null){
            return  Response.status(404).entity("Usuario não existe no banco").build();
        }
        this.service.deletePacient(id);
        return Response.ok(paciente).status(200).entity("Usuario deletado com sucesso").build();
    }
}
