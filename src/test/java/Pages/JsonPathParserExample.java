package Pages;
import io.restassured.path.json.JsonPath;
import java.util.List;

public class JsonPathParserExample {
    public static void main(String[] args)
    {

        String jsonInput = """
            {
              "customerId": "CUST-90280",
              "name": "Piyush Dey",
              "segment": "Premium Banking",
              "active": true,
              "accounts": [
                {"accountId": "ACC-1122", "type": "Savings", "balance": 45000.75, "currency": "INR"},
                {"accountId": "ACC-5566", "type": "Mortgage", "balance": -125000.00, "currency": "GBP"}
              ],
              "contact": {"email": "deypiyush8@gmail.com", "city": "Hyderabad"}
            }
        """;

        // Initialize the JsonPath evaluator
        JsonPath jsonPath = new JsonPath(jsonInput);

        // 1. Extract plain values
        String name = jsonPath.getString("name");
        String city = jsonPath.getString("contact.city");

        // 2. Extract values from specific elements in an array
        String firstAccountId = jsonPath.getString("accounts[0].accountId");
        double secondAccountBalance = jsonPath.getDouble("accounts[1].balance");

        // 3. Advanced Filtering using Groovy expressions (highly prized in interviews)
        // Find all account IDs where the currency type is "GBP"
        List<String> gbpAccounts = jsonPath.getList("accounts.findAll { it.currency == 'GBP' }.accountId");

        // Print out your parsed values
        System.out.println("Parsed Name: " + name);
        System.out.println("Parsed City: " + city);
        System.out.println("First Account: " + firstAccountId);
        System.out.println("Second Account Balance: " + secondAccountBalance);
        System.out.println("GBP Accounts found: " + gbpAccounts);
    }
}