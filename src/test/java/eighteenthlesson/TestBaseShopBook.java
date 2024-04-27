package eighteenthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static ninthlesson.attachments.Attach.*;
import static ninthlesson.attachments.Attach.addVideo;

public class TestBaseShopBook {

    @BeforeAll
    public static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        RestAssured.baseURI="https://demoqa.com";
        Configuration.browserSize="1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote= "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        // Для фиксации видео через selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void configurationAfter() {
        screenshotAs("Скрин");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }
}
