package bases;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitionBase extends WebElementBase {

    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public StepDefinitionBase(AppiumDriver driver) {
        super(driver);
    }

    public void swipeTo(By selector, String swipeDirection) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        WebElement element = driver.findElement(selector);

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", swipeDirection,
                "percent", 0.75
        ));
    }
    public void longClick(By selector){
        WebElement element = getElement(selector);
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),
                "duration",1000
        ));

    }

    public WebElement getElement(By selector) { // this func should be in webElement or page class
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector);
    }

    public String getElementText(WebElement element, By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element.findElement(selector).getText();
    }

}
