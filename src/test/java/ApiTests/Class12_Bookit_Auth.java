package ApiTests;

import static io.restassured.RestAssured.*;

import Utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Class12_Bookit_Auth {

    String accessToken = ConfigurationReader.getProperty("token_lead");

    @BeforeClass
    public void setup(){
        baseURI = "https://cybertek-reservation-api-qa3.herokuapp.com";



    }
    @Test
    public void test1(){

        Response response = given().header("Authorization", accessToken)
                .when().get("/api/campuses");

        assertEquals(response.statusCode(),200);

        response.prettyPrint();


    }


}
