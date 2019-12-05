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
