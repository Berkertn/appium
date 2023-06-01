package Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {
    public static void main(String[] args) throws MalformedURLException {
        Driver driverOptions = new Driver(Driver.PlatformNames.android);
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(driverOptions.getDeviceName())
                .setAutomationName(driverOptions.getAutomationName())
                .setApp(driverOptions.getAppPath());

        URL url = new URL("http://0.0.0.0:4723"); //after appium 2.0 we don't use /wd/hub

        AppiumDriver driver = new AndroidDriver(url, options);
    }
}
