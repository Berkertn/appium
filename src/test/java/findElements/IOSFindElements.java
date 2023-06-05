package findElements;

import Driver.CreateDriverSessionUsingOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class IOSFindElements {

    public static void main(String[] args) throws MalformedURLException {

        IOSDriver driver = (IOSDriver) CreateDriverSessionUsingOptions.initDriver("iOS");
        /*AppiumBy accessibilityTextFieldSelector = (AppiumBy) AppiumBy.accessibilityId("Accessibility");

        WebElement accessibilityTextFieldElement = driver.findElement(accessibilityTextFieldSelector);
        System.out.println(accessibilityTextFieldElement.getAttribute("password"));
        System.out.println(accessibilityTextFieldElement.getText());*/
    }
}
