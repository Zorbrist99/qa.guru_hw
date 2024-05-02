package eighteenthlesson;

import eighteenthlesson.models.ModelReqUsersShopBook;
import eighteenthlesson.models.ModelResUsersShopBook;
import io.qameta.allure.Step;

import static eighteenthlesson.specs.Spec.userRequestSpec;
import static eighteenthlesson.specs.Spec.userResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthApi extends TestBaseShopBook {
    @Step("Авторизация в лк")
    public static ModelResUsersShopBook authorization() {

        ModelReqUsersShopBook modelReqUsersShopBook = new ModelReqUsersShopBook();
        modelReqUsersShopBook.setUserName("zorbrist");
        modelReqUsersShopBook.setPassword("Qwerty123456@");

        return given(userRequestSpec)
                .body(modelReqUsersShopBook)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(userResponseSpec)
                .statusCode(200)
                .extract().as(ModelResUsersShopBook.class);
    }
}
