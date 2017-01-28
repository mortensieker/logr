package dk.sieker.logr.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author sieker
 */
@Entity
@NamedQuery(name="allTasks", query = "SELECT t FROM Task t")
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
