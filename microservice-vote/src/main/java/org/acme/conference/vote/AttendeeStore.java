package org.acme.conference.vote;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.NotNull;

@ApplicationScoped
public class AttendeeStore {

    private Map<Long, Attendee> store = new HashMap<>();
    private AttendeeIdGenerator generator = new AttendeeIdGenerator();

    public Attendee save (Attendee attendee) {
        attendee.setId(generator.nextValue());
        store.putIfAbsent(attendee.getId(), attendee);
        return attendee;
    }

    public Optional<Attendee> findById (Long id) {
        return Optional.ofNullable(id)
                .map(store::get);
    }

    private static class AttendeeIdGenerator {

        private AtomicLong sequence = new AtomicLong(0);

        public long nextValue () {
            return sequence.incrementAndGet();
        }

    }

    public Set<Attendee> findAll () {
        return store.values()
                .stream()
                .collect(Collectors.toSet());
    }

    public boolean delete (@NotNull Attendee attendee) {
        return store.remove(attendee.getId(), attendee);
    }
}
