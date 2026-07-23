package Pages.Questions;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class CollectionQuestions {

    static void main() {


        List<String> expectedList = List.of("Apple","Banna","Orange","Cheeku");

        List<String> ActualList = List.of("Orange","Cheeku");

        List<String> commonFruits = new ArrayList<>(expectedList);
        commonFruits.removeAll(ActualList);

        System.out.println("Missing elements " + commonFruits);








    }

    @Then("Hello world {string}")
    public void helloWorld(String name)
    {
        System.out.println("Hello "+name);

    }
}
