package org.acme.conference.session;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
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

    @OneToMany(targetEntity = Speaker.class, mappedBy = "name")
    private Collection<String> speakers = new HashSet<>();

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
    public Collection<String> getSpeakers () {
    return speakers;
  }

  /**
   * @param speakers the speakers to set
   */
    public void setSpeakers (Collection<String> speakers) {
    this.speakers = speakers;
  }
  
}