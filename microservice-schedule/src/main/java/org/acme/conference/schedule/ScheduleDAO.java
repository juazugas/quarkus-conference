package org.acme.conference.schedule;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author jzuriaga
 *
 */
@ApplicationScoped
public class ScheduleDAO {

    public Schedule addSchedule (Schedule schedule) {
        // TODO Auto-generated method stub
        return new Schedule();
    }

    public Optional<Schedule> findById (String id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    public List<Schedule> getAllSchedules () {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    public List<Schedule> findByVenue (String venueId) {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    public List<Schedule> findByDate (LocalDate localDate) {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    public void deleteSchedule (String scheduleId) {
        // TODO Auto-generated method stub

    }

}
