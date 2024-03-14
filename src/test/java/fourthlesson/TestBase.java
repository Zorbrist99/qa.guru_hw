package fourthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import ninthlesson.attachments.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;

import static ninthlesson.attachments.Attach.*;


public class TestBase {

    @BeforeAll
  public static void Configuration() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Команда запускает сессию не локально, а в Docer контейнере
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    //Если хотим делать один скрин после последнего шага теста
    @AfterEach
    public void configurationAfter (){
        screenshotAs( "Скрин");
        pageSource();
        browserConsoleLogs();

    }
}
