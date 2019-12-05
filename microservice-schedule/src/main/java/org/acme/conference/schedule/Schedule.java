package org.acme.conference.schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Representation of the entity Schedule
 * 
 * @author jzuriaga
 *
 */
@Entity
public class Schedule extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "venue_id", nullable = false)
    private int venueId;

    private LocalDate date;

    private LocalTime startTime;

    private Duration duration;

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getVenueId () {
        return venueId;
    }

    public void setVenueId (int venueId) {
        this.venueId = venueId;
    }

    public LocalDate getDate () {
        return date;
    }

    public void setDate (LocalDate startDt) {
        this.date = startDt;
    }

    public LocalTime getStartTime () {
        return startTime;
    }

    public void setStartTime (LocalTime startTime) {
        this.startTime = startTime;
    }

    public Duration getDuration () {
        return duration;
    }

    public void setDuration (Duration duration) {
        this.duration = duration;
    }

}
