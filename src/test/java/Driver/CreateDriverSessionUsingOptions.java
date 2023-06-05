package Driver;

import Driver.Driver.PlatformNames;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {
    public static AppiumDriver initDriver(String platformName) throws MalformedURLException {
        URL url = new URL("http://0.0.0.0:4723");

        switch (platformName) {
            case "Android":

                Driver driverOptions = new Driver(PlatformNames.android);

                UiAutomator2Options options = new UiAutomator2Options()
                        .setDeviceName(driverOptions.getDeviceName())
                        .setAutomationName(driverOptions.getAutomationName())
                        .setApp(driverOptions.getAppPath())
                        .setUdid(driverOptions.getUdId());/*
                        .setAppPackage(driverOptions.getAppPackage())
                        .setAppActivity(driverOptions.getAppActivity());*/
                return new AndroidDriver(url, options);
            case "iOS":

                Driver driverOptionsIOS = new Driver(PlatformNames.ios);

                XCUITestOptions optionsIOS = new XCUITestOptions()
                        .setDeviceName(driverOptionsIOS.getDeviceName())
                        .setAutomationName(driverOptionsIOS.getAutomationName())
                        .setUdid(driverOptionsIOS.getUdId())
                        .setApp(driverOptionsIOS.getAppPath())
                        .setBundleId(driverOptionsIOS.getBundleId());


                return new IOSDriver(url, optionsIOS);
            default:
                throw new IllegalStateException("Unexpected value: " + platformName);
        }


    }
}
