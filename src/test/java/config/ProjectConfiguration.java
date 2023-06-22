package config;

import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Configuration.baseUrl;

public class ProjectConfiguration {
    static BaseConfig baseconfig = ConfigFactory.create(BaseConfig.class, System.getProperties());

    public void configure() {
        baseUrl = baseconfig.baseUrl();
    }
}
