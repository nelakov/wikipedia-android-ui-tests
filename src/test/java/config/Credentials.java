package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static BrowserStackConfig configBrowserstack = ConfigFactory.create(BrowserStackConfig.class);
    public static EmulatorConfig configEmulator = ConfigFactory.create(EmulatorConfig.class, System.getProperties());
    public static SamsungMobileConfig configSamsung = ConfigFactory.create(SamsungMobileConfig.class, System.getProperties());
}