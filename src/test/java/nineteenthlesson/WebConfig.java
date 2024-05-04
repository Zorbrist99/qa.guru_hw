package nineteenthlesson;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${launch}.properties",
        "classpath:web.properties"
})
public interface WebConfig extends Config {

    @Key("launch.environment")
    String getLaunchEnvironment();
    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("webDriver.value")
    String getWebDriver();

}
