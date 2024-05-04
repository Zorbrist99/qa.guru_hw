package nineteenthlesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class OwnerLibraryTests extends BaseOwnerLibrary {

    @Test
    @DisplayName("Проверка загрузки страницы на GitHub")
    void searchEnterprizeInGitHub() {

        step("Открываем главную страницу GitHub", () ->
                open("https://github.com/"));

        step("Проверяем что загрузилась главная страница", () ->
                $(".HeaderMenu--logged-out").$(byText("Solutions")).hover());

        step("Переходим на вкладку Enterprize", () ->
                $("[href='/enterprise']").click());

        step("Проверяем что страница загрузилась", () ->
                $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform.")).shouldBe(visible));
    }
}
