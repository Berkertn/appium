package findElements;


import Driver.CreateDriverSessionUsingOptions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.time.Duration;

public class AndroidFindElements {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver driver = (AndroidDriver) CreateDriverSessionUsingOptions.initDriver("Android");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(driver.getSessionId());


        By viewsSelector = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");
        WebElement viewsButtonElement = driver.findElement(viewsSelector);
        viewsButtonElement.click();

        //swipe
        AppiumBy list = (AppiumBy) AppiumBy.id("android:id/list");
        wait.until(ExpectedConditions.visibilityOfElementLocated(list));
        WebElement element = driver.findElement(list);

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(3000);
        driver.findElement(editText).clear();

        System.out.println("second swipe");

        //swipe to exit
        WebElement element2 = driver.findElement(AppiumBy.id("android:id/decor_content_parent"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element2).getId(),
                "direction", "right",
                "percent", 0.75
        ));

    }
}
