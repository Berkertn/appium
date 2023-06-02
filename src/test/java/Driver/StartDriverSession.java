package Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StartDriverSession {
    public static void main(String[] args) throws MalformedURLException {

        Driver driverCapabilities = new Driver(Driver.PlatformNames.android);
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, driverCapabilities.getPlatformName());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, driverCapabilities.getDeviceName());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, driverCapabilities.getAutomationName());
        caps.setCapability(MobileCapabilityType.UDID, driverCapabilities.getUdId());
        caps.setCapability(MobileCapabilityType.APP, driverCapabilities.getAppPath());

        // if the app installed on virtual machine and want to go direct approach you can try the =>
        /*caps.setCapability("appPackage", driverCapabilities.getAppPackage());
        caps.setCapability("appActivity", driverCapabilities.getAppActivity());*/


        URL url = new URL("http://0.0.0.0:4723"); //after appium 2.0 we don't use /wd/hub

        AppiumDriver driver = new AndroidDriver(url, caps);

        /*DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_pro");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources" + File.separator + "apks" + File.separator + "ApiDemos.apk";
        caps.setCapability(MobileCapabilityType.APP, appPath);

        URL url = new URL("http://0.0.0.0:4723"); //after appium 2.0 we don't use /wd/hub

        AppiumDriver driver = new AndroidDriver(url,caps); // you can create driver for ios, android or both*/
    }
}
