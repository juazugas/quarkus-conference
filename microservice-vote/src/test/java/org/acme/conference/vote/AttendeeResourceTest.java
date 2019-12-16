package org.acme.conference.vote;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import org.junit.jupiter.api.Test;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongo.MongoDatabaseTestResource;
import io.restassured.http.ContentType;

@QuarkusTest
@QuarkusTestResource(value = MongoDatabaseTestResource.class)
public class AttendeeResourceTest {

    private static final String ATTENDEE_NAME = "Attendee Lastname";

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
    }

}
