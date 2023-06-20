package bases;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

    public void longClick(By selector) {
        WebElement element = getElement(selector);
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
    }

    public void scrollTo(By selector, String direction, By selectorForScrollingElement) {
        //selectorForScrollingElement generally listView element in page
        WebElement element = getElement(selectorForScrollingElement);
        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", direction,
                    "percent", 1.0
            ));

            // Check if the element is now visible on the page
            if (isElementVisible(selector)) {
                break; // Exit the loop if the element is visible
            } else if (!canScrollMore && isElementVisible(selector) == false) {
                // Element is not visible, throw an error
                throw new NoSuchElementException("Element with selector " + selector + " was not found");
            }
        }
    }

    private boolean isElementVisible(By selector) {
        try {
            WebElement element = driver.findElement(selector);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void dragAndDrop(By selector) {
        WebElement element = getElement(selector);
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662
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

    public void swipeToIOS(By selector, String swipeDirection) {
        // it should be swipable like not a cell maybe table for ex: By elementLocator = By.xpath("//XCUIElementTypeTable");
        WebElement element = getElement(selector);
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        //       params.put("velocity", 2500);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);

    }

    public void scrollToIOS(By scrollSizeSelector, String direction, By selectorForScrollingElement) {
        //scrollSizeSelector generally listView element in page
        WebElement searchElement = null;
        WebElement scrollingSize = getElement(scrollSizeSelector);

        Map<String, Object> params = new HashMap<>();

        params.put("element", ((RemoteWebElement) scrollingSize).getId());
        params.put("toVisible", true);
        params.put("direction", "down");

        while (true) {
            try {
                searchElement = getElement(selectorForScrollingElement);
                System.out.println("I cant see");
                break;  // Exit the loop once the element is found and action is performed
            } catch (Exception e) {
                driver.executeScript("mobile: scroll", ImmutableMap.of(
                        "direction", "down",
                        "element", ((RemoteWebElement) scrollingSize).getId(),
                        "toVisible", true
                ));
            }
        /*Map<String, Object> params = new HashMap<>();
        if ("accesbilty Id is set" != null) {
            params.put("element", ((RemoteWebElement) element).getId());
            params.put("toVisible", true);
        }

        driver.executeScript("mobile: scroll", params);*/
        }


    }
}