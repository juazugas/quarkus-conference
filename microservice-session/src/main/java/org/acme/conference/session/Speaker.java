package org.acme.conference.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Speaker {

    @Id
    @Column(unique = true)
    String name;

}
