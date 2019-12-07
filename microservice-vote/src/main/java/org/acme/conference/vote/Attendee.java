package org.acme.conference.vote;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Attendee entity
 * 
 * @author jzuriaga
 *
 */
public class Attendee {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return "Attendee [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Attendee other = (Attendee) obj;
        if (!Objects.equals(this.id, other.id))
            return false;
        if (!Objects.equals(this.name, other.name))
            return false;
        return true;
    }

}
