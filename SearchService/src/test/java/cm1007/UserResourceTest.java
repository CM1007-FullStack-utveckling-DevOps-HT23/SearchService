package cm1007;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestSecurity(authorizationEnabled = false)
public class UserResourceTest {

    @Test
    public void testGetDoctorsByFullName() {
        String fullName = "Jane Doe";

        RestAssured.given()
                .queryParam("fullName", fullName)
                .when()
                .get("/getDoctors/byFullName")
                .then()
                .statusCode(200)
                .body("[0].doctorName", equalTo(fullName));
    }
}