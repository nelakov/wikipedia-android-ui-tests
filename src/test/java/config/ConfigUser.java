package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources("classpath:config/creds.properties")
public interface ConfigUser extends Config {

    @Key("user")
    String user();
    @Key("key")
    String key();
    @Key("app")
    String app();
    @Key("url")
    String url();

}
