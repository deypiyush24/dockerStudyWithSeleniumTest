package Pages.Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class StringQuestions {


    static void main() {


        // Anagram means Frequency of the letters is Same
//        checkAnangram(input, compare);

        // Longest Substring without Repeating Characters

//        String input = "abcabcbb";
//        longestSubstringWithoutRepeating(input);

//        String[] input = {"eat","tea","tan","ate","nat","bat"};
//        groupAnagramsFromArray(input);
//        groupTheAnagram(input);
//        groupTheAnagramUpdated(input);

/*
String Question 3: Longest Palindromic Substring

Input: s = "babad"

Output: "bab" (or "aba")

Input 2: s = "cbbd"

Output 2: "bb"

        String input = "babad";
        longestPalindromicSubstring(input);
 */

        /*
        Array Question 1: Product of Array Except Self

Input: nums = [1, 2, 3, 4]

Output: [24, 12, 8, 6]

Input 2: nums = [-1, 1, 0, -3, 3]

Output 2: [0, 0, 9, 0, 0]
             productofArrayExceptSelfUpdated(nums); // This is more Correct
        productofArrayExceptSelf(nums);
         */

/*

Collections Question 1: Top K Frequent Elements

Input: nums = [1, 1, 1, 2, 2, 3], k = 2

Output: [1, 2]

Input 2: nums = [1], k = 1

Output 2: [1]

        int[] nums= {1, 1, 1, 2, 2, 3};
        int frequency = 2;
        withFrequencyFindTheValue(nums, frequency);
 */



/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.*/
      /*
         String[]  stringArray = {"flower","flow","flight"}
      longestPreFixThatMatch(stringArray); */

      String[]  stringArray = {"flower","flow","flowht"};
      LongestPrefix(stringArray);


    }

    private static void LongestPrefix(String[] stringArray) {
        String firstValue = stringArray[0];
        String longestValue = "";

        for(int i=0; i<firstValue.length();i++)
        {
            String subString = firstValue.substring(0,i);
            boolean value = false;
            for(String str : stringArray)
            {
                value = false;
                value = str.contains(subString);

            }
            if(value)
            {
                longestValue =  subString;
                break;
            }

            else {
                longestValue =  "Empty String";
            }

        }

        System.out.printf(" Longest common word  %s and length %d", longestValue,longestValue.length()).println();
    }

    private static void longestPreFixThatMatch(String[] stringArray) {
        int shortestStringLength = getShortestStringLength(stringArray);
        String firstString = stringArray[0];
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i< shortestStringLength; i++)
        {
            char firstChar = firstString.charAt(i);
            boolean value =false;
            for(String eachValue : stringArray)
            {
                value =false;
                if(eachValue.charAt(i) == firstChar)
                {
                    value = true;
                }
            }
            if(value)
            {
                builder.append(firstChar);
            }
        }
        if(builder.toString().isEmpty())
        {
            System.out.println("No Common prefix found");
        }
        else
        {
            System.out.println(builder);
        }
    }

    private static int getShortestStringLength(String[] stringArray) {
        int shortestStringLength =Integer.MAX_VALUE;
        for(int i = 1; i< stringArray.length; i++) {
            int lengthCompare = Integer.min(stringArray[i-1].length(), stringArray[i].length());
            if(lengthCompare< shortestStringLength)
            {
                shortestStringLength = lengthCompare;
            }
        }
        return shortestStringLength;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0)
            {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    private static void longestNonRepeartingSubstring(String s) {
                /*
        Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers
         */


        String input = s.toLowerCase().replaceAll("[.!?]|\\s+","");
        int lengthOfString = s.length();
        String previousSubString="";
        String longestSubStringWithOutRepeating = "";
        for(int i=1; i<lengthOfString; i++)
        {
            previousSubString=input.substring(0,i-1);
            String subString = input.substring(0,i);// Min Length = 2
            HashMap<Character,Integer> map=new HashMap<>();
            char[] ch = subString.toCharArray();
            for(char c: ch)
            {
                map.merge(c,1,Integer::sum);
            }


            if(map.containsValue(2))
            {
                longestSubStringWithOutRepeating= previousSubString;
                break;
            }
            else{
                previousSubString= subString;
            }


        }

        System.out.println(longestSubStringWithOutRepeating);
    }

    private static void lengthOfStringAsManytimes() {
        String s = "helloworld";
        StringBuilder builder= new StringBuilder();
        int len = 5;
        for(char eachChar: s.toLowerCase().replaceAll("\\s+","").toCharArray())
        {
            int count =len;
            while(count>0)
            {
                builder.append(eachChar);
                count--;
            }

        }


        if(builder.toString().length() == s.length()*len)
        {
            System.out.printf("Length is %d times : %s%n",len, builder);
        }
    }

    private static void repeatingWordFetch(String value) {
                /*
        Collections Question 3: First Unique Character in a Data Stream

Input: stream = "geeksforgeeks"

Output: ['g', 'g', 'g', 'g', 'g', 'e', 'e', 'e', 'e', 'e', 'e', 'r', 'r'] (First non-repeating character evaluated at each step)
String value ="geeksforgeeks";
        repeatingWordFetch(value);
         */

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : value.toCharArray()) {
            map.merge(c,1,Integer::sum);
        }


        StringBuilder builder = new StringBuilder();

        for(HashMap.Entry<Character,Integer> entry : map.entrySet()) {

            Integer count = entry.getValue();

            if(count> 1)
            {
                StringBuilder builderInner = new StringBuilder();
                while(count>0)
                {
                    builderInner.append(entry.getKey()).append(" ");
                    count--;
                }
                builder.append(builderInner);
            }

        }

        System.out.println(builder);
    }

    private static void withFrequencyFindTheValue(int[] nums, int frequency) {
        highestFrequency(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int eachNumber : nums) {

            map.merge(eachNumber, 1, Integer::sum);
        }


        int key =0;
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {

            if(entry.getValue() >= frequency) {
//                frequency = entry.getValue();
                key = entry.getKey();
            }
        }

        System.out.println("frequency: " + frequency + " key: " + key);
    }

    private static void highestFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int eachNumber : nums) {

            map.merge(eachNumber, 1, Integer::sum);
        }


        System.out.println(map);

        int frequency = 0;
        int key =0;
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {

            if(entry.getValue() > frequency) {
                frequency = entry.getValue();
                key = entry.getKey();
            }
        }

        System.out.println("frequency: " + frequency + " key: " + key);
    }

    private static void productofArrayExceptSelfUpdated(int[] nums) {
        int[] output = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int productOfArray=1;
            int valueAtIndexI= nums[i];
            for(int j = 0; j< nums.length; j++) {

                int valueAtIndexJ= nums[j];
                if(valueAtIndexJ != valueAtIndexI) {
                    productOfArray =productOfArray* nums[j];
                }


            }
            output[i] = productOfArray;
        }

        System.out.println(Arrays.toString(output));
    }

    private static void productofArrayExceptSelf(int[] nums) {
        int productOfArray=1;

        int[] output = new int[nums.length];
        for(int value : nums)
        {
            productOfArray = productOfArray * value;
        }

        for(int i = 0; i< nums.length; i++)
        {
            if(!(nums[i] == 0))
            {
                output[i]= productOfArray/ nums[i];
            }
            else {
                output[i]=  nums[i];
            }

        }

        System.out.println(Arrays.toString(output));
    }

    private static void longestPalindromicSubstring(String input) {
        for(int i = 0; i< input.length(); i++)
        {
            for(int j = i; j< input.length(); j++)
            {
                String subString = input.substring(i, j+1);
                if(subString.length()>2 && !subString.isBlank())
                {
                    StringBuilder stringBuilder = new StringBuilder(subString.toLowerCase());
                    if(stringBuilder.reverse().toString().equals(subString)) {
                        System.out.println(subString);
                    }
                }

            }

        }
    }

    private static void groupAnagramsFromArray(String[] input) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String eachString : input) {
            char[] c = eachString.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            // This Method help to create the Row to Map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // If the Key is already there just fetch the Key add the Value to list
            ArrayList<String> list = map.get(key);
            list.add(eachString);

        }
        for (ArrayList<String> eachList : map.values()) {
            System.out.println(eachList);
        }
    }

    private static void groupTheAnagram(String[] input) {
        HashMap<Integer, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int counter = 0;

        for (String eachValue : input) {
            StringBuilder sb = new StringBuilder();
            char[] convertedValue = eachValue.toCharArray();
            Arrays.sort(convertedValue);
            for (char c : convertedValue) {
                sb.append(c);
            }
            map.put(counter, sb.toString());
            set.add(sb.toString());
            counter++;
        }

        Map<String, ArrayList<Integer>> map2 = new HashMap<>();

        for (String eachValue : set) {
            ArrayList<Integer> list = new ArrayList<>();
            for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getValue().equals(eachValue)) {
                    list.add(entry.getKey());
                }
            }
            map2.put(eachValue, list);
        }

        ArrayList<String[]> output = new ArrayList<>();
        for (String eachKey : map2.keySet()) {
            List<Integer> list = map2.get(eachKey);
            String[] currentValue = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {

                currentValue[i] = input[list.get(i)];

            }
            output.add(currentValue);

        }
        for (String[] eachValue : output) {
            System.out.println(Arrays.toString(eachValue));
        }
    }

    private static void groupTheAnagramUpdated(String[] input) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : input) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        for (List<String> group : map.values()) {
            System.out.println(group);
        }
    }

    private static void longestSubstringWithoutRepeating(String input) {
        int endValue = 0;
        for (int i = 0; i < input.length(); i++) {
            // Start is include and end excluded
            String subStringOfInput = input.substring(0, i + 1);
            if (subStringOfInput.length() > 1 && !(subStringOfInput.isEmpty())) {
                char[] charArray = subStringOfInput.toCharArray();
                HashMap<Character, Integer> map = new HashMap<>();
                for (char c : charArray) {
                    map.merge(c, 1, Integer::sum);
                }
                if (map.containsValue(2)) {
                    endValue = i;
                    System.out.println("Frequency found two current Substring for the letter ");
                    break;
                }


            }
        }
        String longestNoRepeated = input.substring(0, endValue);
        System.out.print(longestNoRepeated + " Length " + longestNoRepeated.length());
    }

    private static void checkAnangram(String input, String compare) {
        input = input.toLowerCase();
        compare = compare.toLowerCase();

        char[] a = input.toCharArray();
        char[] b = compare.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if (Arrays.equals(a, b) && input.length() == compare.length()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
