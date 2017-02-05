package dk.sieker.logr.task;

import io.swagger.annotations.Api;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author sieker
 */
@Api(tags = "tasks")
@Path("tasks")
public class TaskResource {
    
    @Inject
    TaskService service;
    
    public List<Task> getAll() {
        return service.getAll();
    }
    
    public Task get(@PathParam("id") long id) {
        return service.get(id);
    }
    
    public void delete(@PathParam("id") long id) {
        service.delete(id);
    }
    
}
