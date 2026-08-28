package Utills.SeleniumQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Webtable {

    static void main() {
        WebDriver driver = new ChromeDriver();
        String runTimeValue = "value";
        String inputValue = String.format("Piyush%s",runTimeValue);

        String xpathToTheWebTable = "Xpath to WebTable";
        Wait<WebDriver> explictWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement webTableWebElement = explictWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToTheWebTable)));
        String relativeXpathToTheFirstColumnOfTheRow = "./xpath-to-the-first-row";

        List<WebElement> allTheRowsOfFirstColumn = webTableWebElement.findElements(By.xpath(relativeXpathToTheFirstColumnOfTheRow));

        String xpathOfSecondColumnOfTheRow = "./xpath-to-the-second-row";
        String  xpathOfThirdColumnOfTheRow = "./xpath-to-the-third-row";

        for(WebElement eachRowFirstColumn : allTheRowsOfFirstColumn){

            String secondValueOfFirstRow = eachRowFirstColumn.findElement(By.xpath(xpathOfSecondColumnOfTheRow)).getText();

            if(secondValueOfFirstRow.equalsIgnoreCase(inputValue))
            {
                eachRowFirstColumn.findElement(By.xpath(xpathOfThirdColumnOfTheRow)).click();
            }

        }


    }
}
