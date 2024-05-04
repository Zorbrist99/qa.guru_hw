package nineteenthlesson;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:remote.properties"
})
public interface RemoteConfig extends Config {

    @Key("remote.webDriver")
    String getRemoteWebDriver();

    @Key("remote.webDriverVersion")
    String getRemoteWebDriverVersion();

}
