package cm1007;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;

@QuarkusTest
@TestSecurity(authorizationEnabled = false)
public class PatientResourceTest {

    @Test
    public void testGetPatientsByFullName() {
        String fullName = "John Doe";

        RestAssured.given()
                .queryParam("fullName", fullName)
                .when()
                .get("/getPatients/byFullName")
                .then()
                .statusCode(200)
                .body("[0].patientName", equalTo(fullName));
    }

    @Test
    public void testGetPatientsByConditionType() {
        String conditionType = "Flu";

        RestAssured.given()
                .queryParam("conditionType", conditionType)
                .when()
                .get("/getPatients/byConditionType")
                .then()
                .statusCode(200)
                .body("[0].patientId", not(emptyOrNullString()));
    }

    @Test
    public void testGetPatientsByDoctorFullName() {
        String doctorId = "-2";

        RestAssured.given()
                .queryParam("doctorId", doctorId)
                .when()
                .get("/getPatients/byDoctorId")
                .then()
                .statusCode(200)
                .body("[0].patientId", not(emptyOrNullString()));
    }
}
