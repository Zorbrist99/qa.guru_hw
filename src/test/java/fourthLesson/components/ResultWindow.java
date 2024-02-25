package fourthLesson.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultWindow {

    public void checkResult(String key, String value){
        $(".table-responsive").shouldHave(text(key)).parent().shouldHave(text(value));
    }
}
