package Pages;

import Utills.DriverFactory;
import Utills.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.BasePage;

import java.time.Duration;
import java.util.List;

public class Google {


    public static void main(String[] args) {

        ////Here Able to fetch the All the Dynamically generate values

        String valueToPassed = "INDIA";
        DriverFactory.initDriver("chrome");
        WebDriver driverInstanceOne = DriverManager.getDriver();
        driverInstanceOne.get("https://www.google.com");

        driverInstanceOne.manage().window().maximize();

        driverInstanceOne.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(valueToPassed);

        Wait<WebDriver> webDriverWait = new  WebDriverWait(driverInstanceOne, Duration.ofSeconds(5));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Alh6id']")));
        List<WebElement> allElementValue = driverInstanceOne.findElements(By.xpath("//li[@data-attrid='AutocompletePrediction']"));

        for(WebElement eachData:allElementValue )
        {
            System.out.println(eachData.getText());
        }

        DriverManager.quitDriver();

    }

}
