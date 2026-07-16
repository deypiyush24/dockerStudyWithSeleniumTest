package Pages.PojoClass;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidationClass {



    public static void main(String[] args) throws Exception {
        String json = """
        {
          "id": 101,
          "name": "Sarah Jenkins",
          "isActive": true,
          "profileDetails": {
            "role": "QA Automation Engineer",
            "department": "Engineering"
          },
          "contactLogistics": [
              {
                "type": "work",
                "number": "555-0192"
              },
              {
                "type": "personal",
                "number": "555-4432"
              }
            ]
        }
        """;

        ObjectMapper mapper = new ObjectMapper();
        UserClass user = mapper.readValue(json, UserClass.class);

        // Now you can easily use clean object-oriented code in your assertions!
        System.out.println("User Name: " + user.getName());
        System.out.println("Role: " + user.getProfileDetails().getRole());
        System.out.println("First Contact Type: " + user.getContactLogistics().getFirst().getType());


    }

}
