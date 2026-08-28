package Pages;

import Pages.PojoClass.UserClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class APITesting {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("API Testing");


        Map<String,String> formParameters = new HashMap<>();
        formParameters.put("grant_type","cilent-credentials");
        formParameters.put("client_id","6790cjvcoup87");
        formParameters.put("client_scerets","6790cjvcoup87");
        String tokenURL ="PiyushURL";



      Response responseFromTokenURL =
              RestAssured.given().formParams(formParameters).when().post(tokenURL)
                      .then().statusCode(200).log().all()
                      .extract().response();

        String token = responseFromTokenURL.jsonPath().getString("AccessToken");

        String combineUrl = "BASEURL" + "EndpointURL";

        Response finalResponseFromEndpoint = RestAssured.given().header ("Authorisation", "Bearer " + token).when().get(combineUrl).then().log().all().
                statusCode(200).extract().response();

        finalResponseFromEndpoint.jsonPath().getString("access_token");


        String bearerToken = String.format("Bearer %s",token);


//        Response updatedData = RestAssured.given().header("Authorization",bearerToken).when().post(combineUrl).then().log().all().statusCode(201).extract().response();

         Response value = RestAssured.given().header("Authorisation", " Bearer Token").when().get(combineUrl).then().log().all().statusCode(200).extract()
                 .response();

         value.jsonPath().getString("token");

         ObjectMapper responseMapper = new ObjectMapper();
         responseMapper.readValue(value.toString(),UserClass.class);


//        int toku = updatedData.jsonPath().getInt("access_token");
//
//        ObjectMapper schemaMapper = new ObjectMapper();
//        UserClass schema = schemaMapper.readValue(updatedData.toString(), UserClass.class);



        Response ResponSeFromAPI = RestAssured.given().header("Authorisation", "Token").when().get(combineUrl).then().log().all().statusCode(200).extract().response();

        ObjectMapper mapper = new ObjectMapper();
        UserClass completeScheme = mapper.readValue(ResponSeFromAPI.toString(),UserClass.class);

    }
}
