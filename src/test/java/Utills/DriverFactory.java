package Utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static void initDriver(String browser) throws MalformedURLException {

        WebDriver driver;

        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "remoteDriver":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); // Run headless for optimal speed
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
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

