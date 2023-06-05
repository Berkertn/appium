package findElements;

import Driver.CreateDriverSessionUsingOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;


import java.net.MalformedURLException;

public class AndroidFindElements {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver driver = (AndroidDriver) CreateDriverSessionUsingOptions.initDriver("Android");
        System.out.println(driver.getSessionId());

        AppiumBy accessibilityTextFieldSelector = (AppiumBy) AppiumBy.accessibilityId("Accessibility");

        WebElement accessibilityTextFieldElement = driver.findElement(accessibilityTextFieldSelector);
        System.out.println(accessibilityTextFieldElement.getAttribute("password"));
        System.out.println(accessibilityTextFieldElement.getText());
    }
}
