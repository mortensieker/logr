/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sieker.logr.week;

import dk.sieker.logr.log.Log;
import dk.sieker.logr.log.LogService;
import java.time.LocalDateTime;
import java.time.Month;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author msa
 */
public class WeekResourceTest {

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
    public void testGet() {
        Log l1 = new Log();
        Log l2 = new Log();
        Log l3 = new Log();
        LocalDateTime t1 = LocalDateTime.of(2017, Month.JANUARY, 2, 20, 0);
        LocalDateTime t1e = LocalDateTime.of(2017, Month.JANUARY, 2, 21, 0);
        l1.setStartTime(t1);
        l1.setEnd_time(t1e);
        LocalDateTime t2 = LocalDateTime.of(2017, Month.JANUARY, 3, 20, 0);
        LocalDateTime t2e = LocalDateTime.of(2017, Month.JANUARY, 3, 22, 0);
        l2.setStartTime(t2);
        l2.setEnd_time(t2e);
        LocalDateTime t3 = LocalDateTime.of(2017, Month.JANUARY, 4, 20, 0);
        LocalDateTime t3e = LocalDateTime.of(2017, Month.JANUARY, 5, 1, 0);
        l3.setStartTime(t3);
        l3.setEnd_time(t3e);
        service.create(l1);
        service.create(l2);
        service.create(l3);
    }
    
}
