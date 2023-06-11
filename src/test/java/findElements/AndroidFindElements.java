package findElements;


import Driver.CreateDriverSessionUsingOptions;
import bases.StepDefinitionBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.net.MalformedURLException;

public class AndroidFindElements {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver driver = (AndroidDriver) CreateDriverSessionUsingOptions.initDriver("Android");
        StepDefinitionBase steps = new StepDefinitionBase(driver);
        System.out.println(driver.getSessionId());


        By viewsSelector = AppiumBy.accessibilityId("Views");

        By textFields = AppiumBy.accessibilityId("TextFields");
        WebElement viewsButtonElement = steps.getElement(viewsSelector);
        viewsButtonElement.click();
        //scrollTo
        steps.scrollTo(AppiumBy.accessibilityId("Visibility"),"down",By.id("android:id/list"));


        //Drag and drop
        //steps.getElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        //steps.dragAndDrop(By.id("io.appium.android.apis:id/drag_dot_1"));

        //long click
        //steps.longClick(By.id("io.appium.android.apis:id/drag_dot_1"));

        //swipe
        /*
        AppiumBy list = (AppiumBy) AppiumBy.id("android:id/list");
        steps.swipeTo(list,"up");*/


    }
}
