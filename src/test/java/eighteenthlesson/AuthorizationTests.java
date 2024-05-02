package eighteenthlesson;

import com.codeborne.selenide.Selenide;
import eighteenthlesson.models.ModelReqAddBooksInBasket;
import eighteenthlesson.models.ModelReqDeleteBooks;
import eighteenthlesson.models.ModelReqUsersShopBook;
import eighteenthlesson.models.ModelResUsersShopBook;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Collections;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static eighteenthlesson.specs.Spec.userRequestSpec;
import static eighteenthlesson.specs.Spec.userResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@DisplayName("Корзина")
public class AuthorizationTests extends TestBaseShopBook {

    ModelReqUsersShopBook modelReqUsersShopBook = new ModelReqUsersShopBook();

    @Test
    @Tag("web")
    @DisplayName("Тест на web авторизацию")
    void authorizationWebTests() {

        step("Открыть страницу", () -> {
            open("/profile");
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
    @Tag("api")
    @DisplayName("Тест на API авторизацию")
    void authorizationApiTests() {

        modelReqUsersShopBook.setUserName("zorbrist");
        modelReqUsersShopBook.setPassword("Qwerty123456@");


        Response authResponse = given()
                .log().body()
                .body(modelReqUsersShopBook)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")

                .then()
                .log().body()
                .log().status()
                .statusCode(200)
                .extract().response();

        open("/images/gplaypattern.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.path("token")));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.path("expires")));

        open("/profile");
        $("#userName-value").shouldHave(text(modelReqUsersShopBook.getUserName())).shouldBe(visible);
    }

    @Test
    @DisplayName("Тест на добавление/удаление книг в корзинe")
    void addBookToCart() {
        modelReqUsersShopBook.setUserName("zorbrist");
        modelReqUsersShopBook.setPassword("Qwerty123456@");

        Response authResponse = given()
                .log().body()
                .body(modelReqUsersShopBook)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")

                .then()
                .log().body()
                .log().status()
                .statusCode(200)
                .extract().response();

        //API для очищения корзины

        String userId = "{\"userId\": \"73643252-1128-487d-b3bc-0b8cde9e51f2\"}";
        given()
                .log().body()
                .log().uri()
                .body(userId)
                .contentType(JSON)
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .when()
                .delete("/BookStore/v1/Books?UserId=73643252-1128-487d-b3bc-0b8cde9e51f2")
                .then()
                .log().body()
                .log().status()
                .statusCode(204);

        //Написать api для добавления книги в корзину
        String value = "{\"userId\": \"73643252-1128-487d-b3bc-0b8cde9e51f2\",\"collectionOfIsbns\": [{\"isbn\": \"9781449325862\"}]}";


        given()
                .log().body()
                .log().uri()
                .body(value)
                .contentType(JSON)
                //Нужно добавить инфу о токене пользователя, что бы он понимал кому добавлять книги
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .log().body()
                .log().status()
                .statusCode(201);

        //Подкладываем cookie
        open("/images/gplaypattern.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.path("token")));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.path("expires")));

        //Очищаем корзину руками и проверяем, что она пустая
        open("/profile");
        $(".rt-tbody").shouldHave(text("Git Pocket Guide")).shouldBe(visible);
        $(".text-right.button.di").$(byText("Delete All Books")).click();
        $(".modal-footer").$(byText("OK")).click();
        Selenide.confirm();
        $(".rt-noData").shouldHave(text("No rows found")).shouldBe(visible);
    }


    @Test
    @Tag("api")
    @DisplayName("Тест на добавление/удаление книг в корзинe с моделями")
    void deleteBookToCart() {

        modelReqUsersShopBook.setUserName("zorbrist");
        modelReqUsersShopBook.setPassword("Qwerty123456@");

        ModelResUsersShopBook authResponse = step("POST.Авторизация в лк", () ->
                given(userRequestSpec)
                        .body(modelReqUsersShopBook)
                        .contentType(JSON)
                        .when()
                        .post("/Account/v1/Login")
                        .then()
                        .spec(userResponseSpec)
                        .statusCode(200)
                        .extract().as(ModelResUsersShopBook.class));


        ModelReqDeleteBooks modelReqDeleteBooks = new ModelReqDeleteBooks();
        modelReqDeleteBooks.setUserId(authResponse.getUserId());

        step("DELETE. Очищение корзины товаров", () ->
                given(userRequestSpec)
                        .body(modelReqDeleteBooks)
                        .contentType(JSON)
                        .queryParam("UserId", authResponse.getUserId())
                        .header("Authorization", "Bearer " + authResponse.getToken())
                        .when()
                        .delete("/BookStore/v1/Books")
                        .then()
                        .spec(userResponseSpec)
                        .statusCode(204));


        ModelReqAddBooksInBasket modelReqAddBooksInBasket = new ModelReqAddBooksInBasket();
        modelReqAddBooksInBasket.setUserId(authResponse.getUserId());
        ModelReqAddBooksInBasket.CollectionOfIsbns collectionOfIsbns = new ModelReqAddBooksInBasket.CollectionOfIsbns();
        collectionOfIsbns.setIsbn("9781449325862");
        modelReqAddBooksInBasket.setCollectionOfIsbns(Collections.singletonList(collectionOfIsbns));


        step("POST.Добавляем книгу в корзину", () ->
                given(userRequestSpec)
                        .body(modelReqAddBooksInBasket)
                        .contentType(JSON)
                        //Нужно добавить инфу о токене пользователя, что бы он понимал кому добавлять книги
                        .header("Authorization", "Bearer " + authResponse.getToken())
                        .when()
                        .post("/BookStore/v1/Books")
                        .then()
                        .spec(userResponseSpec)
                        .statusCode(201));


        step("Подкладываем cookie, для авторизации через UI", () -> {
            open("/images/gplaypattern.jpg");
            getWebDriver().manage().addCookie(new Cookie("userID", authResponse.getUserId()));
            getWebDriver().manage().addCookie(new Cookie("token", authResponse.getToken()));
            getWebDriver().manage().addCookie(new Cookie("expires", authResponse.getExpires()));
        });

        step("Открываем уже авторизованный лк", () -> {
            open("/profile");
        });

        //Проверяем что пользователь залогинен

        step("Проверяем, что книга добавлена", () -> {
            $(".rt-tbody").shouldHave(text("Git Pocket Guide")).shouldBe(visible);
        });
        step("Нажимаем кнопку очищения корзины", () -> {
            $(".text-right.button.di").$(byText("Delete All Books")).click();
        });
        step("Подтверждаем свой выбор", () -> {
            $(".modal-footer").$(byText("OK")).click();
        });
        step("Проверяем, что корзина пуста", () -> {
            Selenide.confirm();
            $(".rt-noData").shouldHave(text("No rows found")).shouldBe(visible);
        });
    }

    @Test
    @Tag("api/web")
    @DisplayName("Тест на добавление/удаление книг в корзинe с убранными API запросами")
    void deleteBookToCartApi() {
        BasketApi basketApi = new BasketApi();
        CartPage cartPage = new CartPage();



        ModelResUsersShopBook authResponse = AuthApi.authorization();
        basketApi.cleaningBasket(authResponse.getUserId(), authResponse.getToken());
        basketApi.addBookTheCart(authResponse.getUserId(), authResponse.getToken());
        basketApi.addCookie(authResponse.getUserId(), authResponse.getToken(), authResponse.getExpires());
        cartPage.openPersonalAccount()
                .userVerification("zorbrist")
                .checkingBook()
                .cleaningBasket()
                .confirmation()
                .checkShoppingCartEmpty();
    }
}

