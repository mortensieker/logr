/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sieker.logr.log;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sieker
 */
public class LogServiceTest {
    
    LogService service;
    
    @Before
    public void init() {
        service = new LogService();
        service.em = Persistence.createEntityManagerFactory("integration").createEntityManager();
        service.em.getTransaction().begin();
    }
    
    @After
    public void teardown() {
        service.em.getTransaction().rollback();
    }
    
    @Test
    public void simpleJPATest() throws Exception {
        List<Log> logs = service.getAll();
        assertTrue(logs.isEmpty());
        Log log = new Log();
        LocalDateTime now = LocalDateTime.now();
        log.setStartTime(now);
        Log l = service.create(log);
        logs = service.getAll();
        assertTrue(logs.size() == 1);
        assertEquals(logs.get(0).getStartTime(), now);
    }
    
}
