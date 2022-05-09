package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({"classpath:config/credentials.properties"})
public interface ConfigUser extends Config {

    String user();

    String key();

    String app();

    String url();

}
