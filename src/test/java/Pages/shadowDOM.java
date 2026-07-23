package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class shadowDOM {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to your target page
        driver.get("YOUR_URL_HERE");


        /*
        NOTE: ALways use CSS Selectors
        // 1. Locate the Shadow Host element in the main DOM
        WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-host-id"));

        // 2. Get the Shadow Root SearchContext
        SearchContext shadowRoot = shadowHost.getShadowRoot();

      Shadhow Root actually got to Shadow host

        // 3. Find and interact with the element INSIDE the Shadow DOM
        WebElement targetElement = shadowRoot.findElement(By.cssSelector(".target-input-class"));
        targetElement.sendKeys("Automating Shadow DOM!");

         */


        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("\"ntp-app\""))));

        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class).withMessage("Element not found after 5sec");
        fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("\"ntp-app\""))));

//        Wait<WebDriver> explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("\"ntp-app\""))));
//
//
//
//        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).
//                ignoring(NoSuchElementException.class).ignoring(ElementNotInteractableException.class).withMessage("Element is not interactable after 30 sec");











//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Locate the first Shadow Host (<ntp-app>) Here we get the First
            WebElement ntpAppHost = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.tagName("ntp-app"))
            );

            // Step 2: Get the Shadow Root of <ntp-app>
            SearchContext ntpAppShadowRoot = ntpAppHost.getShadowRoot();

            // Step 3: Find the nested search box host inside ntp-app's Shadow DOM
            // (Typically <ntp-realbox> or an element with id="realbox")
            WebElement realboxHost = ntpAppShadowRoot.findElement(By.cssSelector("ntp-realbox"));

            // Step 4: Get the Shadow Root of <ntp-realbox>
            SearchContext realboxShadowRoot = realboxHost.getShadowRoot();

            // Step 5: Locate the actual input field inside the inner Shadow DOM
            WebElement searchBar = realboxShadowRoot.findElement(By.cssSelector("input#input"));

            // Step 6: Interact with the search bar
            searchBar.sendKeys("Selenium with Shadow DOM");
            searchBar.submit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}




