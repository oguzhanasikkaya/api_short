package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SpartanTests {

    String spartanBaseUrl = "http://54.196.128.118:8000";


    @Test
    public void viewSpartan_Test1(){

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        //print the status code
        System.out.println("response.statusCode() = " + response.statusCode());

        //print body on the one line
        System.out.println("response.body().asString() = " + response.body().asString());

        //print body by json format
        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

    }


}
