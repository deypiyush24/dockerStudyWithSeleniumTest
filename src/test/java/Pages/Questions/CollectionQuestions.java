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


//
//        System.out.println("Missing elements " + commonFruits);

        
        /*         String input = "CEDCABEBAD";
        Requirement Frequency of Second highest and data should come in Alphabetcially second last one if there is tie in frequency

        secondHighestFrequencyWithSecondLastElement(input)
                */


//        int[] input = {1,2,3,3,5,6,7,8,8,9};
//        duplicateMethod(input);

    }

    private static void duplicateMethod(int[] input) {
        Integer[] inputInt=  Arrays.stream(input).boxed().toArray(Integer[]::new);

        HashSet<Integer> uniqueValues = new HashSet<>(Arrays.asList(inputInt));

        System.out.print(uniqueValues);
    }

    private static void secondHighestFrequencyWithSecondLastElement(String input) {
        char[] c = input.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        for(char eachChar : c )
        {
            map.merge(eachChar,1,Integer::sum);
        }

        ArrayList<Integer> valuesList =new ArrayList<>(map.values());
        Collections.sort(valuesList);
        int secondHighestFrequency = valuesList.get(valuesList.size()-2);

        ArrayList<Character> secondLastWithSecondHighestFrequency =new ArrayList<>();

        for(HashMap.Entry<Character,Integer> entry: map.entrySet())
        {
            if(entry.getValue() ==secondHighestFrequency)
            {
                secondLastWithSecondHighestFrequency.add(entry.getKey());

            }
        }

        Collections.sort(secondLastWithSecondHighestFrequency);

        System.out.println(secondLastWithSecondHighestFrequency.get(secondLastWithSecondHighestFrequency.size()-2));
    }

    @Then("Hello world {string}")
    public void helloWorld(String name)
    {
        System.out.println("Hello "+name);

    }
}
