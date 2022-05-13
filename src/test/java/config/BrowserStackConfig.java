package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources("classpath:config/browserstack.properties")
public interface BrowserStackConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("url")
    String url();
}
