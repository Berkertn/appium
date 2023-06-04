package Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {
    public static void main(String[] args) throws MalformedURLException {

        Driver driverOptions = new Driver(Driver.PlatformNames.android);

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(driverOptions.getDeviceName())
                .setAutomationName(driverOptions.getAutomationName())
                .setApp(driverOptions.getAppPath());

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url, options);
        System.out.println("session id: " + driver.getSessionId());

        // IOS

       /* Driver driverOptions = new Driver(Driver.PlatformNames.ios);
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName(driverOptions.getDeviceName())
                .setAutomationName(driverOptions.getAutomationName())
                .setApp(driverOptions.getAppPath());

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new IOSDriver(url, options);*/
    }
}
