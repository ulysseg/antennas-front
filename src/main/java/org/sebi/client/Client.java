package org.sebi.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.sebi.incident.Incident;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/rest/incidents")
@RegisterRestClient(configKey = "inc")
public interface Client {

    @GET
    List<Incident> getIncidents(@QueryParam("APIKEY") String key);
}
