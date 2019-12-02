package org.acme.conference.session;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SessionRepository {

  private Map<String, Session> sessions = new HashMap<>();

  public SessionRepository() { }

  public SessionRepository (Map<String, Session> sessions) {
    this.sessions = sessions;
  }

	public Collection<Session> findAll() {
		return sessions.values();
  }

	public Session persist(Session session) {
    sessions.put(session.getId(), session);
    return session;
	}

	public Optional<Session> find(String criteria, String sessionId) {
    return Optional.ofNullable(sessionId)
                   .map(sessions::get);
	}

	public void delete(final Session session) {
    Optional.ofNullable(session)
      .map(Session::getId)
      .ifPresent(sessions::remove);
  }
  
}
