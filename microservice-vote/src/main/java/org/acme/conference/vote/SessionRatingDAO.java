package org.acme.conference.vote;

import java.util.Collection;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SessionRatingDAO {

    public static SessionRating rateSession (SessionRating sessionRating) {
        sessionRating.persist();
        return sessionRating;
    }

    public Collection<SessionRating> getAllRatings () {
        return SessionRating.findAll().list();
    }

    public SessionRating updateRating (SessionRating updated) {
        updated.update();
        return updated;
    }

    public Optional<SessionRating> getByRatingId (String ratingId) {
        return SessionRating.find("ratingId", ratingId).firstResultOptional();
    }

    public void delete (SessionRating rating) {
        rating.delete();
    }

}
