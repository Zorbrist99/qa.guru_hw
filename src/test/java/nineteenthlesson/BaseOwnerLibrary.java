package nineteenthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static ninthlesson.attachments.Attach.*;

public class BaseOwnerLibrary {

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("launch", "remote");

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.remote = config.getWebDriver();
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();


        SelenideLogger.addListener("allure", new AllureSelenide());
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
        Selenide.closeWebDriver();
    }
}
