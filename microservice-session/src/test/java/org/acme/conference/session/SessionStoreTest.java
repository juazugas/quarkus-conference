package org.acme.conference.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.acme.conference.session.SessionFakeFactory.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * SessionStore
 */
public class SessionStoreTest {

  private SessionStore store;

  private Map<String, Session> sessionsRepo;

  @BeforeEach
  public void setUp() {
    sessionsRepo = new HashMap<>();
    store = new SessionStore(new SessionRepository(sessionsRepo));
  }

  @Test
  public void testPersist() {
    Session result = null;
    Session session = composeSession();

    result = store.save(session);

    assertNotNull(result);
    assertEquals(DEFAULT_ID, result.getId());
  }

  @Test
  public void testUpdateById() {
    Session result = null;
    Session session = composeSession();
    sessionsRepo.put(DEFAULT_ID, session);

    // given 
    session.setSchedule(DEFAULT_SCHEDULE);

    result = store.updateById(DEFAULT_ID, session).get();

    assertNotNull(result);
    assertEquals(DEFAULT_SCHEDULE, session.getSchedule());
  }

  @Test
  public void testFindById() {
    Session result = null;
    sessionsRepo.put(DEFAULT_ID, composeSession());

    result = store.findById(DEFAULT_ID).get();

    assertNotNull(result);
    assertEquals(DEFAULT_ID, result.getId());
  }

  @Test
  public void testDeleteById() {
    Session result = null;
    sessionsRepo.put(DEFAULT_ID, composeSession());

    result = store.deleteById(DEFAULT_ID).get();

    assertNotNull(result);
    assertEquals(DEFAULT_ID, result.getId());
    assertEquals(0, sessionsRepo.size());
  }
  
}