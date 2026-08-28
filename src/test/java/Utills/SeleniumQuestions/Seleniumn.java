package Utills.SeleniumQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Seleniumn {

    static void main() {
        System.out.println("Seleniumn");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
            String xpathOfAmazonLogo = "//a[@id='nav-logo-sprites']";
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement amazonLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOfAmazonLogo)));
            assert amazonLogo != null;
            String value = amazonLogo.getAttribute("aria-label");
            System.out.printf("We are on landing page, %s", value).println();
            String inputValue = "Iphone";
            String searchBox = "//input[@id='twotabsearchtextbox' and @role='searchbox']";
            driver.findElement(By.xpath(searchBox)).sendKeys(inputValue);
            String search = "//input[@id='nav-search-submit-button' and @type='submit']";
            driver.findElement(By.xpath(search)).click();
            //h2[contains(@aria-label,'iPhone')]/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row puis-desktop-list-row']//span[@class='a-price-whole']
            String productName = "//h2[contains(@aria-label,'iPhone')]";
            List<WebElement> allProduct = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(productName)));
            assert allProduct != null;

            HashMap<String, String> map = new HashMap<>();

            String xpathForThePrice = "./ancestor::div[@data-cy='title-recipe']/following-sibling::div[contains(@class,'puisg-row')]//span[@class='a-price-whole']";
            for (WebElement element : allProduct) {

                String products = element.getText();
                String price = element.findElement(By.xpath(xpathForThePrice)).getText();
                map.put(products, price);

            }
            map.forEach((k,v)-> System.out.println(k + ": " + v));
            driver.quit();


// Convert @aria-label to lowercase and search for "iphone"
//        String productName = "//h2[contains(translate(@aria-label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'iphone')]";



    }
}
