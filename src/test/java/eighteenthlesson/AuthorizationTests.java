package eighteenthlesson;

import com.codeborne.selenide.Configuration;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthorizationTests {

    @Test
    @DisplayName("Тест на web авторизацию")
    void authorizationWebTests() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";

        step("Открыть страницу", () -> {
            open("https://demoqa.com/profile");
        });
        step("Перейти на вкладку логирования", () -> {
            $(".form-label").$(byText("login")).click();
        });
        step("Ввести логин", () -> {
            $("#userName").setValue("zorbrist");
        });
        step("Ввести пароль", () -> {
            $("#password").setValue("Qwerty123456@");
        });
        step("Нажать на кнопку login", () -> {
            $("#login").click();
        });
        step("Проверить, что пользователь zorbrist авторизован", () -> {
            $("#userName-value").shouldHave(text("zorbrist")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Тест на API авторизацию")
    void authorizationApiTests() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy="eager";



        String value = "{\"userName\": \"zorbrist\", \"password\": \"Qwerty123456@\"}";

        Response authResponse = given()
                .log().body()
                .body(value)
                .contentType(JSON)
                .when()
                .post("https://demoqa.com/Account/v1/Login")

                .then()
                .log().body()
                .log().status()
                .statusCode(200)
                .extract().response();

        open("https://demoqa.com/images/gplaypattern.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.path("token")));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.path("expires")));

        open("https://demoqa.com/profile");
        $("#userName-value").shouldHave(text("zorbrist")).shouldBe(visible);
    }
}

