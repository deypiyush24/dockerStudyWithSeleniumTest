package Utills.SeleniumQuestions;

public class Pratice {

    static void main() {

//        List<String> values = List.of("Ramesh","Suresh","Maesh","Piyu");
//        values.forEach(s -> {
//            if(s.length()> 3)
//            {
//                System.out.println("This is name :" + s);
//            }
//
//        });

        String text = "Galaxy S26 Ultra 5G";

        String xpath = String.format("//h2[contains(@aria-label,'%s')]/ancestor::div[contains(@class,'a-spacing-top-small')]/descendant::span[@class='a-price']/span[@class='a-offscreen']",text);

        System.out.println(xpath);



    }
}
