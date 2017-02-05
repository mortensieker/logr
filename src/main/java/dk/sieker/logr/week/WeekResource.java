package dk.sieker.logr.week;

import dk.sieker.logr.log.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sieker
 */
@Api("weeks")
@Path("weeks")
@Produces(MediaType.APPLICATION_JSON)
public class WeekResource {

    @Inject
    LogService service;
    
    @GET
    @Path("{weeknum}")
    @ApiOperation(value = "GET", notes = "Returns all the logs for a given week")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "week not found")})
    public void get(
            @ApiParam(value = "ID of log to fetch", required = true, allowableValues = "1-52", defaultValue = "current week")
            @PathParam("weeknum") Integer week) {
        
    }

}
