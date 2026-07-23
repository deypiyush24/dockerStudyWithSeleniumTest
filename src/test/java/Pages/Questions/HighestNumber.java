package Pages.Questions;


import java.util.*;

public class HighestNumber {

    static void main() {
        int[] uniqueArray = {1, 4, 6, 7, 8, 2, 345, 90};

        Integer[] object = Arrays.stream(uniqueArray).boxed().toArray(Integer[]::new);

        List<Integer> list = new ArrayList<>(Arrays.asList(object));
        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));


        int highestNumber = uniqueArray[0];

        for (int eachValue : uniqueArray) {

            if (eachValue > highestNumber) {
                highestNumber = eachValue;
            }
        }

        int secondHighestNumber = -1;

        for (int eachValue : uniqueArray) {

            if (eachValue < highestNumber && eachValue > secondHighestNumber) {
                secondHighestNumber = eachValue;
            }
        }


        System.out.println(secondHighestNumber);
    }
}
