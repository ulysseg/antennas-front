package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.sebi.client.Client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("rest/incidents")
public class IncidentResource {

    @RestClient
    Client client;

    @ConfigProperty(name = "org.sebi.incident.incidentservice.mp.rest.url")
    String key;
    
    @GET
    public List<Incident> getIncidents(){
       return client.getIncidents(key);
    } 
}
