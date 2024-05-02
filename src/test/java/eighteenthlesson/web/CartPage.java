package eighteenthlesson.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    SelenideElement nameBook = $(".rt-tbody"),
            basketStatus = $(".rt-noData");


    @Step("Открываем лк")
    public CartPage openPersonalAccount() {
        open("/profile");
        return this;
    }

    @Step("Проверяем что мы залогинились под нужным пользователем")
    public CartPage userVerification(String userName) {
        $(byText(userName)).shouldBe(visible);
        return this;
    }

    @Step("Проверяем что книга добавлена")
    public CartPage checkingBook() {
        nameBook.shouldHave(text("Git Pocket Guide")).shouldBe(visible);
        return this;
    }

    @Step("Очищаем корзину")
    public CartPage cleaningBasket() {
        $(byText("Delete All Books")).click();
        return this;
    }

    @Step("Подтверждаем свой выбор")
    public CartPage confirmation() {
        $(byText("OK")).click();
        return this;
    }

    @Step("Проверяем, что корзина пуста")
    public CartPage checkShoppingCartEmpty() {
        Selenide.confirm();
        basketStatus.shouldHave(text("No rows found")).shouldBe(visible);
        return this;
    }
}
