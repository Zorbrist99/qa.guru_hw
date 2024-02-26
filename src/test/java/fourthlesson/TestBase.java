package fourthlesson;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    @BeforeEach
   void Configuration() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        //Команда позволяет не ждать прогрузки страницы, а сразу искать элементы в доме
        Configuration.pageLoadStrategy = "eager";
    }
}
