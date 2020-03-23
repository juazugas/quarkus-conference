package org.acme.conference.schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * @author jzuriaga
 *
 */
@ApplicationScoped
public class ScheduleDAO {

    @Transactional
    public Schedule addSchedule (Schedule schedule) {
        schedule.persist();
        return schedule;
    }

    @Transactional
    public Schedule saveSchedule (int id, final Schedule newSched) {
        Optional<Schedule> schedule = findById(id);
        if (schedule.isPresent()) {
            schedule.map(s -> {
                s.setVenueId(newSched.getVenueId());
                s.setDate(newSched.getDate());
                s.setStartTime(newSched.getStartTime());
                s.setDuration(newSched.getDuration());
                return s;
            }).orElseThrow().persist();
        }
        return schedule.orElseThrow();
    }

    public Optional<Schedule> findById (int id) {
        Schedule schedule = Schedule.find("id", id)
                .firstResult();
        return Optional.ofNullable(schedule);
    }

    public List<Schedule> getAllSchedules () {
        return Schedule.findAll()
                .list();
    }

    public List<Schedule> findByVenue (int venueId) {
        return Schedule.find("venueId", venueId)
                .list();
    }

    public List<Schedule> findByDate (LocalDate date) {
        return Schedule.find("date", date)
                .list();
    }

    @Transactional
    public boolean deleteSchedule (int id) {
        Optional<Schedule> schedule = findById(id);
        if (schedule.isPresent()) {
            schedule.get()
                    .delete();
            return true;
        }
        return false;
    }

}
