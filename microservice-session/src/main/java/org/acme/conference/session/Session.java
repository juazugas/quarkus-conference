package org.acme.conference.session;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

/**
 * Session entity
 * 
 */
@Entity
public class Session {

    @Id
    @NotBlank
    private String id;

    private int schedule;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Speaker> speakers = new HashSet<>();

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @param schedule the schedule to set
   */
  public void setSchedule(int schedule) {
    this.schedule = schedule;
  }

  /**
   * @return the schedule
   */
  public int getSchedule() {
    return schedule;
  }

  /**
   * @return the speakers
   */
    public Collection<Speaker> getSpeakers () {
    return speakers;
  }

  /**
   * @param speakers the speakers to set
   */
    public void setSpeakers (Collection<Speaker> speakers) {
    this.speakers = speakers;
  }
  
}