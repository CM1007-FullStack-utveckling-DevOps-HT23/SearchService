package cm1007;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;

@QuarkusTest
@TestSecurity(authorizationEnabled = false)
public class EncounterResourceTest {

    @Test
    public void testFindByEncounterDate() {
        String encounterDateString = "2024-01-04";
        String doctorId = "-2";

        RestAssured.given()
                .queryParam("encounterDate", encounterDateString)
                .queryParam("doctorId", doctorId)
                .when()
                .get("/getEncounters/byDate")
                .then()
                .statusCode(200)
                .body("[0].id", not(emptyOrNullString()));
    }

    @Test
    public void testFindByDoctorId() {
        String doctorId = "-2";

        RestAssured.given()
                .queryParam("doctorId", doctorId)
                .when()
                .get("/getEncounters/byDoctorId")
                .then()
                .statusCode(200)
                .body("[0].id", not(emptyOrNullString()));
    }
}
