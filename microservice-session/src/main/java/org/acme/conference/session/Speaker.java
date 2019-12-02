package org.acme.conference.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Speaker {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    public static Speaker from (String speakerName) {
        Speaker speaker = new Speaker();
        speaker.setName(speakerName);
        return speaker;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
}
