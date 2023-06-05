package findElements;

import Driver.CreateDriverSessionUsingOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class IOSFindElements {

    public static void main(String[] args) throws MalformedURLException {

        IOSDriver driver = (IOSDriver) CreateDriverSessionUsingOptions.initDriver("iOS");


        //ıd,name
        //AppiumBy activityIndicatorsTextSelector = (AppiumBy) AppiumBy.accessibilityId("Activity Indicators");
        AppiumBy activityIndicatorsTextSelector = (AppiumBy) AppiumBy.id("Activity Indicators");
        WebElement accessibilityTextFieldElement = driver.findElement(activityIndicatorsTextSelector);
        System.out.println(accessibilityTextFieldElement.getLocation());
        System.out.println(accessibilityTextFieldElement.getAttribute("value"));
        System.out.println(accessibilityTextFieldElement.getText());


        //class name
        AppiumBy activityIndicatorsTextSelector2 = (AppiumBy) AppiumBy.className("XCUIElementTypeStaticText");
        WebElement iosTextFieldElement = driver.findElement(activityIndicatorsTextSelector2);
        System.out.println(iosTextFieldElement.getLocation());
        System.out.println(iosTextFieldElement.getAttribute("value"));
        System.out.println(iosTextFieldElement.getText());

        //xpath
        By activityIndicatorsTextSelector3 =  By.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]");
        WebElement iosTextFieldElement2 = driver.findElement(activityIndicatorsTextSelector3);
        System.out.println(iosTextFieldElement2.getLocation());
        System.out.println(iosTextFieldElement2.getAttribute("value"));
        System.out.println(iosTextFieldElement2.getText());
    }
}
