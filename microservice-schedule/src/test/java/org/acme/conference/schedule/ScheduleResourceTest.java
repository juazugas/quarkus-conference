package org.acme.conference.schedule;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import java.util.List;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ScheduleResourceTest {

    private static final int GIVEN_ID = 101;
    private static final int GIVEN_VENUE_ID = 101;

    @Test
    public void testHelloEndpoint() {
        given()
                .when()
                .get("/schedule/ehlo")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testRetrieve() {
        given()
            .when()
                .get("/schedule/" + GIVEN_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo(GIVEN_ID))
                .body("venueId", equalTo(GIVEN_VENUE_ID));
    }

    @Test
    public void testAllSchedules() {
        Long count = Schedule.count();

        List<Schedule> schedules = given()
            .when()
            .get("/schedule/all")
            .thenReturn().<List<Schedule>>as(List.class);
        assertThat(schedules, hasSize(count.intValue()));
    }

    @Test
    public void testDelete () {
        given().when()
                .delete("/schedule/1")
                .then()
                .statusCode(204);
    }

}