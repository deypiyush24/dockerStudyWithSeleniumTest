package Pages;

import Utills.DriverFactory;
import Utills.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Google {


    public static void main(String[] args) throws InterruptedException {

        ////Here Able to fetch the All the Dynamically generate values


//        String value = "Cooler";
//        String url = "https://www.amazon.in/";
//        DriverFactory.initDriver("chrome");

        URLs value1 = URLs.Base_URL_ITN3;
        String urlValue = value1.getValue();
        System.out.println(urlValue);


//
//        extractValueFormSearchBoxFluentWait(value,url);
//
//        DriverManager.quitDriver();


    }

    private static void extractValueFormSearchBox(String value,String url) {
        WebDriver driverInstanceOne = DriverManager.getDriver();
        driverInstanceOne.get(url);
        By searchBoxLocator = By.xpath("//input[@id='twotabsearchtextbox' or @role='searchbox']");
        WebDriverWait webdriverWait = new WebDriverWait(driverInstanceOne, Duration.ofSeconds(10));
        WebElement searchBoxWebelement = webdriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxLocator));
        searchBoxWebelement.sendKeys(value);

        By autosuggestion= By.xpath("//div[contains(@id,'sac-suggestion-row') and @role='gridcell']/div[@role='button']");
        List<WebElement> listOfAutosuggestion = webdriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autosuggestion));
        HashMap<Integer, String> map = new HashMap<>();
        int counter = 1;
        for(WebElement eachValue: listOfAutosuggestion)
        {
            map.put(counter,eachValue.getText());
            counter ++;

        }
        System.out.println(map);
    }

    private static void extractValueFormSearchBoxUpdate(String value,String url) {
        WebDriver driverInstanceOne = DriverManager.getDriver();
        driverInstanceOne.get(url);
        By searchBoxLocator = By.xpath("//input[@id='twotabsearchtextbox' or @role='searchbox']");

        Wait<WebDriver> webdriverWait = new WebDriverWait(driverInstanceOne, Duration.ofSeconds(10));
        WebElement searchBoxWebelement = webdriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxLocator));
        searchBoxWebelement.sendKeys(value);

        By autosuggestion= By.xpath("//div[contains(@id,'sac-suggestion-row') and @role='gridcell']/div[@role='button']");
        List<WebElement> listOfAutosuggestion = webdriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autosuggestion));
        HashMap<Integer, String> map = new HashMap<>();
        int counter = 1;
        for(WebElement eachValue: listOfAutosuggestion)
        {
            map.put(counter,eachValue.getText());
            counter ++;

        }
        System.out.println(map);
    }


    private static void extractValueFormSearchBoxFluentWait(String value,String url) {
        WebDriver driverInstanceOne = DriverManager.getDriver();
        driverInstanceOne.get(url);
        By searchBoxLocator = By.xpath("//input[@id='twotabsearchtextbox' or @role='searchbox']");
        Wait<WebDriver> webdriverWait = new FluentWait<>(driverInstanceOne).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).
                ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);

        WebElement searchBoxWebelement = webdriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxLocator));
        searchBoxWebelement.sendKeys(value);

        By autosuggestion= By.xpath("//div[contains(@id,'sac-suggestion-row') and @role='gridcell']/div[@role='button']");
        List<WebElement> listOfAutosuggestion = webdriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autosuggestion));
        HashMap<Integer, String> map = new HashMap<>();
        int counter = 1;
        for(WebElement eachValue: listOfAutosuggestion)
        {
            map.put(counter,eachValue.getText());
            counter ++;

        }
        System.out.println(map);
    }



    private static void searchDataInGoogle() {
        String valueToPassed = "INDIA";
        DriverFactory.initDriver("chrome");
        WebDriver driverInstanceOne = DriverManager.getDriver();
        driverInstanceOne.get("https://www.google.com");

        driverInstanceOne.manage().window().maximize();

        //textarea[@id='input' or @role='combobox']
        driverInstanceOne.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(valueToPassed);

        Wait<WebDriver> webDriverWait = new WebDriverWait(driverInstanceOne, Duration.ofSeconds(5));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Alh6id']")));
        List<WebElement> allElementValue = driverInstanceOne.findElements(By.xpath("//li[@data-attrid='AutocompletePrediction']"));

        for (WebElement eachData : allElementValue) {
            System.out.println(eachData.getText());
        }

        DriverManager.quitDriver();
    }

}
