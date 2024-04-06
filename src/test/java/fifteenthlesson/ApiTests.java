package fifteenthlesson;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    void searchNameUsers() {
        given()
                .log().uri()
                .get("/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(12))
                .body("data.first_name", hasItem("Michael"));
    }

    @Test
    void searchNonExistentUser() {
        given()
                .log().uri()
                .get("/users/160")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

    @Test
    void postNewUsers() {
        String value = "{\"name\": \"sergei\",\"job\": \"it\"}";
        given()
                .log().body()
                .body(value)
                .contentType(JSON)
                .log().uri()

                .when()
                .post("/users")

                .then()
                .log().body()
                .body("name", equalTo("sergei"))
                .body("job", equalTo("it"));
    }

    @Test
    void  updateUsers (){
        String newValueUser = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";

        given()
                .log().body()
                .body(newValueUser)
                .contentType(JSON)
                .log().uri()

                .when()
                .put("/users/2")

                .then()
                .log().body()
                .log().status()
                .statusCode(200)
                .body("name", equalTo("morpheus"), "job", equalTo("zion resident"));
    }

    @Test
    void deleteUser (){
        given()
                .log().uri()
                .delete("/users/2")
                .then()
                .log().status()
                .statusCode(204);
    }
}
