package dk.sieker.logr.week;

import dk.sieker.logr.log.Log;
import dk.sieker.logr.log.LogService;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author sieker
 */
@Stateless
public class WeekService {
    
    @Inject
    LogService logService;

    public List<Log> getWeekLogs(LocalDate startDate, LocalDate endDate) {

        return Collections.emptyList();
    }
    
    
}
