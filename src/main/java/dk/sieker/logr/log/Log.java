package dk.sieker.logr.log;

import dk.sieker.logr.converter.StringToLocalDateTimeAdapter;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sieker
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name="allLogs", query = "SELECT l FROM Log l"),
    @NamedQuery(name="rangeLogs", query = "SELECT l FROM Log l WHERE l.start_time BETWEEN :start AND :end"),
})
public class Log {
    
    @Id
    @GeneratedValue
    private Long id; 

    @XmlJavaTypeAdapter(StringToLocalDateTimeAdapter.class)
    private LocalDateTime start_time;
    
    @XmlJavaTypeAdapter(StringToLocalDateTimeAdapter.class)
    private LocalDateTime end_time;
   
    private Long taskId;
    
    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return start_time;
    }

    public void setStartTime(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
    
}
