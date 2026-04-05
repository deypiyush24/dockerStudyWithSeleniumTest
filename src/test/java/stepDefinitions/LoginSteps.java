package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;

public class LoginSteps {

    private static final Logger log = Logger.getLogger(LoginSteps.class.getName());

    private WebDriver driver;

    @Given("I open the browser")
    public void i_open_the_browser() {
        String systemValue = System.getProperty("runMode", "local");
        log.info("System value: " + systemValue);

        if (systemValue.equals("docker")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless", "--window-size=1920,1080");
            try {
                // "selenium-hub" is the name of the service in your Docker Compose file
                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I navigate to the OrangeHRM login page")
    public void i_navigate_to_the_orangehrm_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Then("the login page should be displayed")
    public void the_login_page_should_be_displayed() {
        // Wait for the login form to be visible, implicit wait will handle it up to 10s
        boolean isDisplayed = driver.findElement(By.name("username")).isDisplayed();
        Assertions.assertTrue(isDisplayed, "Login form is not displayed");
    }

    @After
    public void tearDown() {
        System.out.println("Driver shut down");
        if (driver != null) {
            driver.quit();
        }
    }
}
