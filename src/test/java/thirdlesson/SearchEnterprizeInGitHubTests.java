package thirdlesson;

import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchEnterprizeInGitHubTests {


    @Test
    void searchEnterprizeInGitHub() {
        //На главной странице GitHub выберите меню Solutions  Enterprize Убедитесь что загрузилась нужная страница
        open("https://github.com/");
        $(".HeaderMenu--logged-out").$(byText("Solutions")).hover();
        //Enterprize
        $("[href='/enterprise']").click();
        //Убедитесь что загрузилась нужная страница
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform.")).shouldBe(visible);
    }


    @Test
    @ParameterizedTest
    void moveToElement() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //!!!Интересная команда на будущее для перетаскивая каких-то элементов на какой-то элемент!!!
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-b").shouldHave(text("A"));

    }

    @Test
    void DragAndDrop() {


        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-b").shouldHave(text("A"));

    }
}
