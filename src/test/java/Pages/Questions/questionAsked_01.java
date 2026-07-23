package Pages.Questions;

import java.util.*;

public class questionAsked_01 {

    static void main() {

        // Repeated Words from String

        // String s = " Piyush is good person Java is java. piyush see";

        // repeatingWordInTheString(s);
        // duplicateStringInStatement(s);

        String s = "Piyush is Fantastics !?.@";
//        findTheRepeatingVowels(duplicateLetter);
//        reverseTheStringInTheSameOrder(s);

        StringBuilder stringBuilder = new StringBuilder(s.toLowerCase().replaceAll("[.!?@\\s+]",""));
        System.out.println(stringBuilder.reverse());

    }

    private static void reverseTheStringInTheSameOrder(String s) {
        String[] splitedValues = s.toLowerCase().replaceAll("[.!?]","").split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for(String eachWord: splitedValues)
        {
            StringBuilder wordBuilder = new StringBuilder(eachWord);
            stringBuilder.append(wordBuilder.reverse()).append(" ");


        }
        System.out.println(stringBuilder);
    }

    public static void findTheRepeatingVowels(String duplicateLetter) 
    {
        char[] charArray = duplicateLetter.toLowerCase().replaceAll("[!?.]", "").replaceAll("\\s+", "").toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char eachValue : charArray) {
            map.merge(eachValue, 1, Integer::sum);
        }
        String vowels = "aeiou";

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            // vowels.indexOf(character) returns >= 0 if the character is found
            // Value is -1 if not found Value is Greater than 0 if found
            if (entry.getValue() > 1 && vowels.indexOf(entry.getKey()) != -1) {
                System.out.println(entry.getKey() + " it's count is :" + entry.getValue());
            }

            System.out.println(vowels.indexOf(entry.getKey()));

        }
    }

    public static void repeatingWordInTheString(String s) {
        List<String> allTheWords = Arrays.asList(s.toLowerCase().split(" "));
        Collections.sort(allTheWords);
        HashSet<String> uniqueWordList = new HashSet<>(allTheWords);

        HashMap<String, Integer> map = new HashMap<>();

        for (String eachUniqueWord : uniqueWordList) {
            int counter = 0;
            for (String eachWord : allTheWords) {
                if (eachUniqueWord.equalsIgnoreCase(eachWord)) {
                    counter++;
                }

            }
            map.put(eachUniqueWord, counter);

        }

        for (String eachValues : map.keySet()) {
            if (map.get(eachValues) > 1) {
                System.out.println(eachValues);
            }
        }

    }





    public static void duplicateStringInStatement(String s) {
        String[] words = s.toLowerCase().replaceAll("[.,!]", "").split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();

        // Single pass: O(N) to populate the map
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.merge(word, 1, Integer::sum);
            }
        }

        // Print only the duplicates
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

}
