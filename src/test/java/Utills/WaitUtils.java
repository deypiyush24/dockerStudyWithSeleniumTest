package Utills;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    //NOTE: Once the Object are created they are final
    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Wait for visibility
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for clickability
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for presence
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for invisibility
    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Fluent wait (advanced)
    public WebElement fluentWait(By locator, int timeout, int polling) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return fluentWait.until(driver -> driver.findElement(locator));
    }

    public static void retryClick(WebDriver driver, By locator, int maxAttempts) {
        int attempt = 0;

        while (attempt < maxAttempts) {
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                attempt++;
                System.out.println("Retrying click... Attempt: " + attempt);
            }
        }

        throw new RuntimeException("Failed to click element after " + maxAttempts + " attempts");
    }

}
