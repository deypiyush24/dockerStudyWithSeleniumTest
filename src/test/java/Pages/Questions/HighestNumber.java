package Pages.Questions;
import java.util.*;

public class HighestNumber
{

    static void main() {
        int[] uniqueArray = {1, 4, 6, 7, 8, 2, 345, 90};

        Arrays.sort(uniqueArray);
        int[] sortedArray = new int[uniqueArray.length];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(uniqueArray).forEach(list::add) ;
        int counter = 0;
        for(int eachValue: uniqueArray)
        {
            for(Integer i: list)
            {
                if(i >eachValue)
                {
                    eachValue=i;
                }

            }
            list.remove(Integer.valueOf(eachValue));
            sortedArray[counter]= eachValue;
            counter++;

        }


//        int[] sortedArray = new int[uniqueArray.length];
//
//        for(int i=0; i<uniqueArray.length;i++)
//        {
//            Integer value = uniqueArray[i];
//            for(Integer each: list)
//            {
//                if(each> value)
//                {
//                    value=each;
//                }
//
//            }
//            list.remove(value);
//            sortedArray[i]= value;
//
//        }
//
        int outValue = sortedArray[sortedArray.length-1];
        System.out.println("The highest number is "+outValue);

//        nthLargestNumber(sortedArray);







    }

    private static void nthLargestNumber(int[] nums) {
        List<Integer> listValue = new ArrayList<>();
        for(int eachValue : nums)
        {
            listValue.add(eachValue);
        }
        int nThValue = 2;

        int outPut = 0;
        while(nThValue>0)
        {
            Integer maximumValue = Integer.MIN_VALUE;
            for(Integer eachValue : listValue)
            {
                maximumValue = Integer.max(maximumValue,eachValue);
            }

            listValue.remove(maximumValue);
            nThValue--;
            outPut =maximumValue;
        }
        System.out.println(outPut);
    }

    private static void Traditionalway(int[] uniqueArray) {
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
    private static void findTheMaximumValueFromIntegerArrayMethod2(int[] uniqueArray) {
        Integer[] object = Arrays.stream(uniqueArray).boxed().toArray(Integer[]::new);

        List<Integer> list = new ArrayList<>(Arrays.asList(object));
        Collections.sort(list);

        System.out.println(list.get(list.size() - 1));
    }

    private static void findTheMaximumValueFromIntegerArray(int[] uniqueArray) {
        int highestNumber1 = Integer.MIN_VALUE;
        for (int eachValue : uniqueArray) {
            highestNumber1 = Integer.max(highestNumber1, eachValue);
        }
    }


}


