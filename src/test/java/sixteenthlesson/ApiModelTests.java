package sixteenthlesson;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sixteenthlesson.model.ModelReqUsers;
import sixteenthlesson.model.ModelResSingleUsers;
import sixteenthlesson.model.ModelResUsers;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static sixteenthlesson.specs.SpecRequest.userRequestSpec;
import static sixteenthlesson.specs.SpecRequest.userResponseSpec;

@DisplayName("API тесты с моделями и спецификациями")
public class ApiModelTests {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @DisplayName("Создание нового пользователя")
    @Test
    void postNewUsers() {
        ModelReqUsers modelRequestUsers = new ModelReqUsers();

        modelRequestUsers.setName("sergei");
        modelRequestUsers.setJob("it");

        ModelResUsers response = step("POST.Создание пользователя", () ->
                given(userRequestSpec)
                        .body(modelRequestUsers)

                        .when()
                        .post("/users")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(201)
                        .extract().as(ModelResUsers.class));

        step("POST.Проверки.Создание пользователя", () -> {
            assertEquals("sergei", response.getName());
            assertEquals("it", response.getJob());
            assertNotNull(response.getId());
            assertNotNull(response.getCreatedAt());
        });
    }


    @DisplayName("Поиск конкретного пользователя")
    @Test
    void searchSingleUsers() {

        ModelResSingleUsers response = step("GET.Поиск конкретного пользователя", () ->
                given(userRequestSpec)
                        .get("/users/2")
                        .then()
                        .spec(userResponseSpec)
                        .statusCode(200)
                        .extract().as(ModelResSingleUsers.class));

        step("GET.Проверка.Данные конкретного пользователя", () -> {
            assertEquals(2, response.getData().getId());
            assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
            assertEquals("Janet", response.getData().getFirstName());
            assertEquals("Weaver", response.getData().getLastName());
            assertNotNull(response.getData().getAvatar());
            assertNotNull(response.getSupport().getText());
        });
    }

    @DisplayName("Поиск несуществующего пользователя")
    @Test
    void searchNonExistentUser() {
        step("GET.Поиск несуществующего пользователя", () ->
                given(userRequestSpec)
                        .get("/users/160")
                        .then()
                        .spec(userResponseSpec)
                        .statusCode(404));
    }


    @DisplayName("Изменение данных уже существующего пользователя")
    @Test
    void updateUsers() {
        ModelReqUsers modelReqUsers = new ModelReqUsers();
        modelReqUsers.setName("morpheus");
        modelReqUsers.setJob("zion resident");

        ModelResUsers response = step("PUT.Запрос на изменение данных существующего пользователя", () ->
                given(userRequestSpec)
                        .body(modelReqUsers)

                        .when()
                        .put("/users/2")

                        .then()
                        .spec(userResponseSpec)
                        .statusCode(200)
                        .extract().as(ModelResUsers.class));

        step("PUT.Проверка изменения сущности действующего пользователя", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("zion resident", response.getJob());
            assertNotNull(response.getUpdatedAt());
        });
    }

    @DisplayName("Удаление пользователя")
    @Test
    void deleteUser() {
        step("DELETE.Удаление пользователя", () ->
                given(userRequestSpec)
                        .delete("/users/2")
                        .then()
                        .spec(userResponseSpec)
                        .statusCode(204));
    }
}
