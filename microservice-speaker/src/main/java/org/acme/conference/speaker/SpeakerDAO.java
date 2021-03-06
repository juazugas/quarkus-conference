package org.acme.conference.speaker;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.panache.common.Sort;

/**
 * SpeakerDAO
 */
@ApplicationScoped
public class SpeakerDAO {

    private SpeakerIdGenerator generator = new SpeakerIdGenerator();

    public Speaker create (Speaker speaker) {
        speaker.setUuid(generator.generate());
        speaker.persist();
        return speaker;
    }

    public Collection<Speaker> findAll(Sort sort) {
        return Speaker.findAll(sort).list();
    }

    public Speaker update (Speaker updated) {
        updated.persist();
        return updated;
    }

    public void delete (Speaker speaker) {
        speaker.delete();
    }

    public Optional<Speaker> getByUuid(String uuid) {
        return Speaker.find("uuid", uuid).firstResultOptional();
    }

    private static class SpeakerIdGenerator {

        public String generate() {
            return UUID.randomUUID().toString();
        }
    }

    public Collection<Speaker> search(String query, Sort sort) {
        String queryUpper = Optional.ofNullable(query)
            .map(String::toUpperCase)
            .map(q -> q.concat("%"))
            .orElse("UNKNOWNUNKNOWN");
        return Speaker.find("upper(nameFirst) like :query or upper(nameLast) like :query", sort, Collections.singletonMap("query", queryUpper)).list();
    }

}