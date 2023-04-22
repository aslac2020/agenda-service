package org.agenda;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/agenda")
public class AgendaResource {

    @GET
    public String hello(){
        return "Hello World";
    }
}
