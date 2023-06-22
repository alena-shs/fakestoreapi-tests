package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:base.properties"
})

public interface BaseConfig extends Config {
    @Key("baseUrl")
    String baseUrl();
}