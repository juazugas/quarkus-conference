package org.acme.conference.session;

import java.util.Collection;
import java.util.HashSet;

/**
 * Session entity
 * 
 */
public class Session {

  private String id;

  private int schedule;

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
  public Collection<String> getSpeakers() {
    return speakers;
  }

  /**
   * @param speakers the speakers to set
   */
  public void setSpeakers(Collection<String> speakers) {
    this.speakers = speakers;
  }
  
}