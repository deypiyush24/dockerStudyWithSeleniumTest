package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.BasePage;
import Utills.WaitUtils;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String user) {
        waitUtils.waitForVisibility(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        waitUtils.waitForVisibility(password).sendKeys(pass);
    }


    public void clickLogin() {
        try {
            waitUtils.waitForClickable(loginBtn).click();
        } catch (Exception e) {
            // fallback retry for flaky UI
            WaitUtils.retryClick(driver, loginBtn, 3);
        }
    }





}
