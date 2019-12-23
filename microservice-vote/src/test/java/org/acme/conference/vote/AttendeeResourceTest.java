package org.acme.conference.vote;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import java.util.Collections;
import java.util.UUID;
import javax.inject.Inject;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongo.MongoDatabaseTestResource;
import io.restassured.http.ContentType;

@QuarkusTest
@QuarkusTestResource(value = MongoDatabaseTestResource.class)
public class AttendeeResourceTest {

    private static final String ATTENDEE_NAME = "Attendee Lastname";
    private static final String ATTENDEE_DEFAULT_NAME = "Default Name";

    @Inject
    MongoClient mongoClient;

    @Test
    public void testCreateEndpoint () {
        given().when()
                .body("{\"name\":\"" + ATTENDEE_NAME + "\"}")
                .contentType(ContentType.JSON)
                .post("/attendee")
                .then()
                .statusCode(200)
                .body("name", equalTo(ATTENDEE_NAME))
                .body("id", not(emptyString()));

        deleteAll();
    }

    @Test
    public void testUpdateEndpoint () {

        Attendee attendee = createDefault();

        given().when()
                .body(Collections.singletonMap("name", ATTENDEE_NAME))
                .contentType(ContentType.JSON)
                .put("/attendee/" + attendee.getId())
                .then()
                .statusCode(200)
                .body("id", equalTo(attendee.getId()))
                .body("name", equalTo(ATTENDEE_NAME));

        deleteAll();
    }

    @Test
    public void testGetAllEndpoint () {
        Attendee attendee = createDefault();
        Attendee attendeeNamed = createWithName("With Name");

        given().when()
                .get("/attendee")
                .then()
                .statusCode(200)
                .body("size()", equalTo(2));

        deleteAll();
    }

    @Test
    public void testGetEndpoint () {
        final String ATT_GETWITH_NAME = "GetWith Name";
        Attendee attendee = createWithName(ATT_GETWITH_NAME);

        given().when()
                .get("/attendee/" + attendee.getId())
                .then()
                .statusCode(200)
                .body("id", equalTo(attendee.getId()))
                .body("name", equalTo(ATT_GETWITH_NAME));

        deleteAll();
    }

    @Test
    public void testDeleteEndpoint () {
        Attendee attendee = createDefault();

        given().when()
                .delete("/attendee/" + attendee.getId())
                .then()
                .statusCode(204);
    }

    private Attendee createDefault () {
        return given().when()
                .body("{\"name\":\"" + ATTENDEE_DEFAULT_NAME + "\"}")
                .contentType(ContentType.JSON)
                .post("/attendee")
                .thenReturn()
                .as(Attendee.class);
    }

    private Attendee createWithName (String name) {
        MongoCollection collection = getCollection();
        Document doc = new Document().append("_id", UUID.randomUUID()
                .toString())
                .append("name", name);
        collection.insertOne(doc);
        Attendee attendee = new Attendee();
        attendee.setId(doc.getString("_id"));
        attendee.setName(doc.getString("name"));
        return attendee;
    }

    private MongoCollection getCollection () {
        MongoCollection collection = mongoClient.getDatabase("votes")
                .getCollection("Attendee");
        return collection;
    }

    private void deleteAll () {
        getCollection().deleteMany(new Document());
    }
}
