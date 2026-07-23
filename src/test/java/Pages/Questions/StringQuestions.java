package Pages.Questions;

import java.util.Arrays;

public class StringQuestions {


    static void main() {
     String input = "CAT";
     String compare = "ACT";


     // Anagram means Frequency of the letters is Same
        checkAnangram(input, compare);

    }

    private static void checkAnangram(String input, String compare) {
        input = input.toLowerCase();
        compare = compare.toLowerCase();

        char[] a = input.toCharArray();
        char[] b = compare.toCharArray();

       int i =0;
        for(char c : a)
        {
            i =i+c;
        }

        System.out.println(i);







    }
}
