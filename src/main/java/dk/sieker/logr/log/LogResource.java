package dk.sieker.logr.log;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
 * @author sieker
 */
@Api(tags = "logs")
@Path("logs")
@Produces(MediaType.APPLICATION_JSON)
public class LogResource {

    @Inject
    LogService service;

    @GET
    @ApiOperation(value = "GET", notes = "Get all logs")
    public List<Log> get() {
        return service.getAll();
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "GET", notes = "Returns a single log based on the provided ID")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "log not found")})
    public Log get(@ApiParam(value = "ID of log to fetch", required = true) @PathParam("id") long id) {
        return service.get(id);
    }

    @POST
    @ApiOperation(value = "POST", notes = "Create a new log")
    public Response create(Log log, @Context UriInfo info) {
        Log persistedLog = service.create(log);
        URI uri = info.getAbsolutePathBuilder().path("/" + persistedLog.getId()).build();
        return Response.created(uri).build();
    }

    @PUT
    @Path("{log}")
    @ApiOperation(value = "PUT", notes = "Update the given log")
    public Log update(@ApiParam(value = "Log to update", required = true) @PathParam("log") Log log) {
        return service.update(log);
    }

}
