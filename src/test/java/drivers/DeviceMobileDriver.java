package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
public class DeviceMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(Credentials.configSamsung.platformName());
        options.setDeviceName(Credentials.configSamsung.deviceName());
        options.setPlatformVersion(Credentials.configSamsung.platformVersion());
        options.setApp(app.getAbsolutePath());
        options.setLocale(Credentials.configSamsung.locale());
        options.setLanguage(Credentials.configSamsung.language());
        options.setAppPackage(Credentials.configSamsung.appPackage());
        options.setAppActivity(Credentials.configSamsung.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }
    public static URL getAppiumServerUrl() {
        try {
            return new URL(Credentials.configSamsung.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    private File getApp() {
        String appPath = Credentials.configSamsung.appPath();
        String appUrl = Credentials.configSamsung.appUrl();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return app;
    }
}
