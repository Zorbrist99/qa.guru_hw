package fourthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;

import static ninthlesson.attachments.Attach.*;


public class TestBase {

    @BeforeAll
    public static void Configuration() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote= "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.baseUrl="https://demoqa.com";
        // Для фиксации видео через selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    //Если хотим делать один скрин после последнего шага теста
    @AfterEach
    public void configurationAfter() {
        screenshotAs("Скрин");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }
}
