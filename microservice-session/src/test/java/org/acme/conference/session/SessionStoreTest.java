package org.acme.conference.session;

import static org.acme.conference.session.SessionFakeFactory.DEFAULT_SCHEDULE;
import static org.acme.conference.session.SessionFakeFactory.composeSession;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

/**
 * SessionStore
 */
@QuarkusTest
public class SessionStoreTest {

    @Inject
    private SessionStore store;

    @Test
    public void testPersist () {
        final String PERSIST_ID = "Store.persist_id";
        Session result = null;
        Session session = composeSession();
        session.setId(PERSIST_ID);

        result = store.save(session);

        assertNotNull(result);
        assertEquals(PERSIST_ID, result.getId());
    }

    @Test
    public void testUpdateById () {
        final String SESSION_ID = "s-1-1";
        Session result = null;
        Session session = composeSession();

        // given
        session.setSchedule(DEFAULT_SCHEDULE);

        result = store.updateById(SESSION_ID, session)
                .get();

        assertNotNull(result);
        assertEquals(DEFAULT_SCHEDULE, session.getSchedule());
    }

    @Test
    public void testFindById () {
        final String SESSION_ID = "s-1-1";
        Session result = null;

        result = store.findById(SESSION_ID)
                .get();

        assertNotNull(result);
        assertEquals(SESSION_ID, result.getId());
    }

    @Test
    public void testDeleteById () {
        final String DELETE_ID = "s-2-1";
        Session result = null;

        result = store.deleteById(DELETE_ID)
                .get();

        assertNotNull(result);
        assertEquals(DELETE_ID, result.getId());
    }

}