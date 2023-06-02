package Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverSession {
    public static void main(String[] args) throws MalformedURLException {

        Driver driverCapabilities = new Driver(Driver.PlatformNames.ios);
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, driverCapabilities.getPlatformName());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, driverCapabilities.getDeviceName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, driverCapabilities.getAutomationName());
        caps.setCapability(MobileCapabilityType.UDID, driverCapabilities.getUdId());
        caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");

        //caps.setCapability(MobileCapabilityType.APP, driverCapabilities.getAppPath());

        URL url = new URL("http://0.0.0.0:4723"); //after appium 2.0 we don't use /wd/hub

        AppiumDriver driver = new IOSDriver(url, caps);
    }
}
