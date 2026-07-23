package Utills;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManagerRemote {

    // 1. ThreadLocal container holding isolated WebDriver instance for each thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Grid Hub URL running inside your Docker container
    private static final String GRID_URL = "http://localhost:4444";

    // 2. Set the driver for the current thread
    public static void setDriver(String browser) throws MalformedURLException {
        WebDriver remoteDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = getChromeOptions();
            remoteDriver = new RemoteWebDriver(new URL(GRID_URL), options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Assign driver instance specifically to current execution thread
        driver.set(remoteDriver);
    }

    private static @NonNull ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // Overcomes limited resource problems
        options.addArguments("--disable-gpu");          // Crucial for Docker container rendering
        options.addArguments("--remote-allow-origins=*");

// Add this if running on Apple Silicon / Mac M-series or experiencing crash on start
        options.addArguments("--disable-software-rasterizer");
        return options;
    }

    // 3. Fetch the driver for the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // 4. Safely close and remove thread reference to avoid memory leaks
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // VERY IMPORTANT: Clears memory reference for ThreadLocal
        }
    }
}