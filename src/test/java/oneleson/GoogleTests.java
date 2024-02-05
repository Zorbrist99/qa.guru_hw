package oneleson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTests {

    @Test
    void selenideSerchTest(){

        Configuration.timeout=60000;

        //Открыть браузер
        open("https://www.google.com/");
        //Ввести Selenide в поиске
        $(byName("q")).setValue("Selenide").pressEnter();
        //Проверить, что Selenide появился в результатах поиска
        $("#search").shouldHave(text("Selenide"));
    }
}
