package nineteenthlesson;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:remote.properties"
})
public interface LocalConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();
}
