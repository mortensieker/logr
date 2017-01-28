package dk.sieker.logr.task;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sieker
 */
@Stateless
public class TaskService {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Task> getAll() {
        return em.createNamedQuery("allTasks", Task.class).getResultList();
    }
    
    public Task get(long id) {
        return em.find(Task.class, id);
    }
    
    public void delete(long id) {
        Task t = get(id);
        if(t != null)
            em.remove(t);
    }
    
    public Task update(Task task) {
        return null;
    }
    
}
