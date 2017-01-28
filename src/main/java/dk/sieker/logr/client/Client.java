package dk.sieker.logr.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author msa
 */
@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
