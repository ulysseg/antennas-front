package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.sebi.client.Client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("rest/incidents")
public class IncidentResource {

    @RestClient
    Client client;

    @ConfigProperty(name = "apikey")
    String key;
    
    @GET
    @Fallback(fallbackMethod = "fallbackIncidents")
    public List<Incident> getIncidents(){
       return client.getIncidents(key);
    }

    public List<Incident> fallbackIncidents() {
        Incident i = new Incident();
        i.description = "fallback incident";
        return List.of(i);
    }
}
