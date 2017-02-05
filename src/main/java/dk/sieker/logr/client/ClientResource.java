package dk.sieker.logr.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author msa
 */
@Api(tags = "clients")
@Path("clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    
    @Inject
    ClientService service;
    
    @GET
    public List<Client> get() {
        return service.getAll(1l);
    }
    
    @GET
    @Path("{id}")
    public Client get(@ApiParam(value = "ID of client to fetch", required = true) @PathParam("id") long id) {
        return service.get(1l, id);
    }

    @POST
    public Response create(Client client, @Context UriInfo info) {
        Client persistedClient = service.create(client);
        URI uri = info.getAbsolutePathBuilder().path("/" + persistedClient.getId()).build();
        return Response.created(uri).build();
    }

    @PUT
    @Path("{client}")
    public Client update(@ApiParam(value = "Client to update", required = true) @PathParam("client") Client client) {
        return service.update(client);
    }
    
}
