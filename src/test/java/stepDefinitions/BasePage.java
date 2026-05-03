package stepDefinitions;

import Utills.WaitUtils;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;


    /// Here we will Pass the Object Instance one Webdriver only
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 10);
    }
}
