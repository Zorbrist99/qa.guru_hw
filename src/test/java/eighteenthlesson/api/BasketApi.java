package eighteenthlesson.api;

import eighteenthlesson.TestBaseShopBook;
import eighteenthlesson.models.ModelReqAddBooksInBasket;
import eighteenthlesson.models.ModelReqDeleteBooks;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import java.util.Collections;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static eighteenthlesson.specs.Spec.userRequestSpec;
import static eighteenthlesson.specs.Spec.userResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BasketApi extends TestBaseShopBook {

    @Step("Очистка корзины")
    public void cleaningBasket(String userId, String token) {

        ModelReqDeleteBooks modelReqDeleteBooks = new ModelReqDeleteBooks();
        modelReqDeleteBooks.setUserId(userId);

        given(userRequestSpec)
                .body(modelReqDeleteBooks)
                .contentType(JSON)
                .queryParam("UserId", userId)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(userResponseSpec)
                .statusCode(204);
    }

    @Step("Добавление книги в корзину")
    public void addBookTheCart(String userId, String token, String isbn) {

        ModelReqAddBooksInBasket modelReqAddBooksInBasket = new ModelReqAddBooksInBasket();
        modelReqAddBooksInBasket.setUserId(userId);
        ModelReqAddBooksInBasket.CollectionOfIsbns collectionOfIsbns = new ModelReqAddBooksInBasket.CollectionOfIsbns();
        collectionOfIsbns.setIsbn(isbn);
        modelReqAddBooksInBasket.setCollectionOfIsbns(Collections.singletonList(collectionOfIsbns));


        given(userRequestSpec)
                .body(modelReqAddBooksInBasket)
                .contentType(JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(userResponseSpec)
                .statusCode(201);
    }

    @Step("Добавление cookie на страницу")
    public void addCookie(String userId, String token, String expires) {
        open("/images/gplaypattern.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
        getWebDriver().manage().addCookie(new Cookie("token", token));
        getWebDriver().manage().addCookie(new Cookie("expires", expires));
    }
}
