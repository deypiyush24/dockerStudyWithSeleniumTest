package Pages;

import java.util.*;
import java.util.stream.IntStream;

public class DemoQuestion {


   static void main(String[] args) {



    }

    private static void missingNumber(int[] array) {
        Arrays.sort(array);
        ArrayList<Integer> newArray = new ArrayList<>();
        for(int eachValue: array)
        {
            newArray.add(eachValue);
        }

        IntStream.range(1,4);
        for(int i = array[0]; i<= array[array.length-1]; i++ )
        {
            if(!newArray.contains(i))
            {
                System.out.println("Not present :" + i);
            }
        }
    }

    private static void secondMaximumNumber(int[] arr) {
        int maxValue = arr[0];
        int secondMaxMumValue = Integer.MIN_VALUE;

        for(int eachValue : arr)
        {
            if(eachValue > maxValue)
            {
                maxValue = eachValue;
            }
        }

        for(int eachValue : arr)
        {
            if(eachValue < maxValue && eachValue > secondMaxMumValue)
            {
                secondMaxMumValue = eachValue;
            }
        }

        System.out.println("This is SecondMax :" +secondMaxMumValue );
    }

    private static void secondMinMumNumber(int[] arr) {
        int minValue = arr[0];
        int secondMinMumValue = Integer.MAX_VALUE;

        for(int eachValue : arr)
        {
            if(eachValue < minValue)
            {
                minValue = eachValue;
            }
        }

        for(int eachValue : arr)
        {
            if(eachValue > minValue && eachValue < secondMinMumValue)
            {
                secondMinMumValue = eachValue;
            }
        }

        System.out.println("This is SeconddMin :" +secondMinMumValue );
    }

    private static void MaximumValueFromArray(int[] arr) {
        int maxValue = arr[0];
        for(int eachValue : arr)
        {
            if(eachValue > maxValue)
            {
                maxValue = eachValue;
            }
        }
        System.out.println("maximum Value :" + maxValue);
    }


    private static void countTheNumberOfWordsIntheWord(String duplicateValues) {
        HashSet<Character> value = new HashSet<>();
        HashMap<Character,Integer> mapForTheValue = new HashMap<>();
        for( char eachLetter : duplicateValues.toCharArray())
        {
            value.add(eachLetter);
        }

        for (char uniqueValue :value )
        {
            int counter = 0;
            for(char eachLetter : duplicateValues.toCharArray())
            {
                if(uniqueValue ==eachLetter )
                {
                    counter++;
                }
            }
            mapForTheValue.put(uniqueValue,counter);
        }
        System.out.println(mapForTheValue);
    }


    private static void reverseTheStatement(String statement) {
        StringBuilder reverseStatement = new StringBuilder();

        for(String eachWord : statement.split(" ") )
        {
            System.out.println(eachWord);
            System.out.println(new StringBuilder(eachWord).reverse());
            reverseStatement.append(" ").append(new StringBuilder(eachWord).reverse());
        }
        System.out.println("This is reverse Statement: " + reverseStatement.toString() );
    }

    private static void findTheCountForTheAlphaBetInInput(String input,char letter) {

        int counter =0;

        for(char value : input.toLowerCase().toCharArray())
        {
            if(value == letter)
            {
                counter ++;
            }
        }
        System.out.println("This is count " +counter );
    }


}
