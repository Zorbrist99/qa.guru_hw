package fourthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import ninthlesson.attachments.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.AfterTest;

import java.util.Locale;

import static ninthlesson.attachments.Attach.screenshotAs;


public class TestBase {

    @BeforeAll
  public static void Configuration() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    //Если хотим делать один скрин после последнего шага теста
    @AfterEach
    public void configurationAfter (){
        screenshotAs( "Скрин");
    }
}
