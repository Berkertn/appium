package bases;

import Driver.CreateDriverSessionUsingOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;

public abstract class WebElementBase {
    protected AppiumDriver driver;

    public WebElementBase(AppiumDriver driver) {
        this.driver = driver;
    }
}
