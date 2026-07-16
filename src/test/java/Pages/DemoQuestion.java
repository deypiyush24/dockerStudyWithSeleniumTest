package Pages;

import java.util.*;
import java.util.stream.IntStream;

public class DemoQuestion {


    public static void main(String[] args) {


        // Notes : Input : "Automation"
        //Output: "noitamotuA"
//
//        String Input = "Automation";
//        StringBuilder reverseString = new StringBuilder();
//        for (int i = Input.length() - 1; i >= 0; i--) {
//            reverseString.append(Input.charAt(i));
//        }
//        System.out.println("This is the value :" + reverseString.toString());
//        StringBuilder newValue = new StringBuilder(Input).reverse();
//        System.out.println("This is the value :" + newValue);


        // Check the Palindrom :
//        Input : "MADAM"
//        Output: True

//        String input = "MADAM1";
//
//        boolean isPalindrome = input.contentEquals(new StringBuilder(input).reverse());
//        System.out.printf("Value is %b" , isPalindrome);

//
//        String name = "palindrome";
//        if(Input.contentEquals(reverseValue))
//        {
//            System.out.printf("Yes %s",name);
//        }
//        else
//        {
//            System.out.printf("Not a %s",name);
//        }


//        Input : "Selenium", 'e'

//        String input = "SeleniumE";
//        char letter = 'e';
//        findTheCountForTheAlphaBetInInput(input,letter);

//        String statement = "This is the world";
//        reverseTheStatement(statement);

//        String duplicateValues= "programming";
//        countTheNumberOfWordsIntheWord(duplicateValues);


        // Find the LargestNumber = int[] arr = {10,20,30,40,50};

        int[] arr = {10000,209,30,4900,4900,50};
//        Arrays.sort(arr);
//        System.out.println("Maximum value :" + arr[arr.length-1]);
//        System.out.println(Arrays.stream(arr).min().getAsInt());
//
//        MaximumValueFromArray(arr);
//        secondMaximumNumber(arr);
//        secondMinMumNumber(arr);


        // Find The Missing Numbers here we Consider First and Last number is range
        int[] array = {5,2,3,6,8,9};
        Arrays.sort(array);
        ArrayList<Integer> newArray = new ArrayList<>();
        for(int eachValue: array)
        {
            newArray.add(eachValue);
        }

        IntStream.range(1,4);
        for(int i = array[0]; i<=array[array.length-1];i++ )
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
