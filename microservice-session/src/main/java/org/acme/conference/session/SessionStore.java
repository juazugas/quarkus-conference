package org.acme.conference.session;

import java.util.Collection;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class SessionStore {

    @Inject
    private SessionRepository repository;

    public SessionStore() {
    }

    public Collection<Session> findAll () {
        return repository.findAll()
                .list();
    }

    @Transactional
    public Session save (Session session) {
        repository.persist(session);
        return session;
    }

    @Transactional
    public Optional<Session> updateById (String sessionId, Session session) {
        Optional<Session> sessionOld = findById(sessionId);
        if (!sessionOld.isPresent()) {
            return Optional.empty();
        }

        sessionOld.ifPresent(s -> {
            s.setSchedule(session.getSchedule());
            s.getSpeakers()
                    .clear();
            s.getSpeakers()
                    .addAll(session.getSpeakers());
            repository.persist(s);
        });
        return Optional.ofNullable(session);
    }

    public Optional<Session> findById (String sessionId) {
        return repository.find("id", sessionId)
                .stream()
                .findFirst();
    }

    @Transactional
    public Optional<Session> deleteById (String sessionId) {
        Optional<Session> session = findById(sessionId);
        if (!session.isPresent()) {
            return Optional.empty();
        }
        repository.delete(session.get());
        return session;
    }

}
