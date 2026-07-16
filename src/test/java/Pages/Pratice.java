package Pages;

import java.util.ArrayList;
import java.util.List;

public class Pratice {

    static void main() {

        List<String> values = List.of("Ramesh","Suresh","Maesh","Piyu");
        values.forEach(s -> {
            if(s.length()> 3)
            {
                System.out.println("This is name :" + s);
            }

        });




    }
}
