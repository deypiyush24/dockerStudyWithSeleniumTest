package Utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public static void initDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();

        // IMPORTANT: No implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        DriverManager.setDriver(driver);
    }


}

