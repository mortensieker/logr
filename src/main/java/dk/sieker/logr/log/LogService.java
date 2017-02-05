package dk.sieker.logr.log;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sieker
 */
@Stateless
public class LogService {
    
    @PersistenceContext
    public EntityManager em;
    
    public List<Log> getAll() {
        List<Log> logs = em.createNamedQuery("allLogs", Log.class).getResultList();
        return logs;
    }
    
    public List<Log> getLogsFromRange(LocalDate start, LocalDate end) {
        List<Log> logs = em.createNamedQuery("rangeLogs", Log.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
        return logs;
    }
    
    public Log get(long id) {
        return em.find(Log.class, id);
    }
    
    public void delete(long id) {
        Log log = get(id);
        if(log != null)
            em.remove(log);
    }
    
    public Log create(Log log) {
        em.persist(log);
        return log;
    }
    
    public Log update(Log log) {
        return em.merge(log);
    }
    
}
