package sixteenthlesson;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sixteenthlesson.model.ModelReqUsers;
import sixteenthlesson.model.ModelResSingleUsers;
import sixteenthlesson.model.ModelResUsers;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static sixteenthlesson.specs.SpecRequest.userRequestSpec;
import static sixteenthlesson.specs.SpecRequest.userResponseSpec;

public class ApiModelTests {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    void postNewUsers() {
        ModelReqUsers modelRequestUsers = new ModelReqUsers();

        modelRequestUsers.setName("sergei");
        modelRequestUsers.setJob("it");

        ModelResUsers response = given(userRequestSpec)
                .body(modelRequestUsers)

                .when()
                .post("/users")

                .then()
                .spec(userResponseSpec)
                .statusCode(201)
                .extract().as(ModelResUsers.class);

        assertEquals("sergei", response.getName());
        assertEquals("it", response.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }


    @Test
    void searchSingleUsers() {

        ModelResSingleUsers response = given(userRequestSpec)
                .get("/users/2")
                .then()
                .spec(userResponseSpec)
                .statusCode(200)
                .extract().as(ModelResSingleUsers.class);

        assertEquals(2, response.getData().getId());
        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        assertEquals("Janet", response.getData().getFirst_name());
        assertEquals("Weaver", response.getData().getLast_name());
        assertNotNull(response.getData().getAvatar());
        assertNotNull(response.getSupport().getText());
    }

    @Test
    void searchNonExistentUser() {
        given(userRequestSpec)
                .get("/users/160")
                .then()
                .spec(userResponseSpec)
                .statusCode(404);
    }


    @Test
    void updateUsers() {
        ModelReqUsers modelReqUsers = new ModelReqUsers();
        modelReqUsers.setName("morpheus");
        modelReqUsers.setJob("zion resident");

        ModelResUsers response = given(userRequestSpec)
                .body(modelReqUsers)

                .when()
                .put("/users/2")

                .then()
                .spec(userResponseSpec)
                .statusCode(200)
                .extract().as(ModelResUsers.class);

        assertEquals("morpheus", response.getName());
        assertEquals("zion resident", response.getJob());
        assertNotNull(response.getUpdatedAt());
    }

    @Test
    void deleteUser() {
        given(userRequestSpec)
                .delete("/users/2")
                .then()
                .spec(userResponseSpec)
                .statusCode(204);
    }

}
