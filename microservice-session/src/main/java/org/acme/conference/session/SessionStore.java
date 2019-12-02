package org.acme.conference.session;

import java.util.Collection;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class SessionStore {

  private SessionRepository repository;

  @Inject 
  public SessionStore(SessionRepository sessionRepository) {
    this.repository = sessionRepository;
  }

	public Collection<Session> findAll() {
		return repository.findAll();
	}

  @Transactional
	public Session save(Session session) {
    repository.persist(session);
    return session;
	}

  @Transactional
	public Optional<Session> updateById(String sessionId, Session session) {
    Optional<Session> sessionOld = findById(sessionId);
    if (!sessionOld.isPresent()) {
      return Optional.empty();
    }

    repository.persist(session);
		return Optional.ofNullable(session);
	}

	public Optional<Session> findById(String sessionId) {
    return repository.find("id", sessionId);
	}

	public Optional<Session> deleteById(String sessionId) {
    Optional<Session> session = findById(sessionId);
    if (!session.isPresent()) {
      return Optional.empty();
    }
    repository.delete(session.get());
		return session;
	}

}
