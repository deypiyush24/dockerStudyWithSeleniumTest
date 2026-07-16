package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingStratyegy {

    public static void main(String[] args) 
    
    {

        WebDriver driver = new ChromeDriver();
        
        // Setting up the explicit wait with a 10-second timeout
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Clicking a button that reveals a new input field
driver.findElement(By.id("reveal")).click();

// Waiting for the specific condition: the element must be visible
WebElement revealedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_input")));
revealedInput.sendKeys("Selenium 4");
    }
    
}
