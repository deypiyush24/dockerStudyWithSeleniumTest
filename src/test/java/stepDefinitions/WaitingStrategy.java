package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingStrategy {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //*  Setting up the explicit wait with a 10-second timeout


// Clicking a button that reveals a new input field
        WebElement element2 = driver.findElement(By.id("reveal"));
        element2.click();

// Waiting for the specific condition: the element must be visible

        // Define Object which take two arguments ----> Driver Object, Time that this Object will wait

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // That object stop waiting right till event occurred that is
        WebElement revealedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_input")));


// Asking JavaScript to execute
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);


        // Fluent Wait come into picture where there I highly level of 'flakiness'  is there example Element comes then goes , Elements blinks etc

        // Customizing the wait to poll every 250ms and ignore specific errors
        // Note: Here We define Object that will wait, How much it will wait , Polling it will do , Ignoring(any exception), Finally a message of error
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("The element was not interactable after 30 seconds");

 // Using the wait with a lambda expression
        WebElement dynamicElement = fluentWait.until(d ->
        {
            WebElement element = d.findElement(By.id("dynamic_id"));
            return element.isDisplayed() ? element : null;
        });


        //NOTE Finally Use the Element
        dynamicElement.sendKeys("Selenium 4");

    }
}
