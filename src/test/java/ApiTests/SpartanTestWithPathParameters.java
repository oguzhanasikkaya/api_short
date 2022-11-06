package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithPathParameters {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI = "http://54.196.128.118:8000";
    }

    /*
    given accept type is Json
    and Id parameter value is 18
    when user sends get request to /api/spartans/{id}
    and response content-type: application/json
    and "Allen" should be in response payload
     */

    @Test(testName = "Path_Parameter_1")
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 18)
                .when().get("api/spartans/{id}");

        assertEquals(response.statusCode(),200);

        assertEquals(response.contentType(),"application/json");

        assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();

    }



    /*
    given accept type is Json
    And Id parameter value is 500
    When user sends get request to /api/spartans/{id}
    Then response status code should be   404
    And response content-type: application/json
    And "Spartan Not Found" message should be in response payload
     */

    @Test(testName = "negative_path_parameter")
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");


        assertEquals(response.statusCode(),404);

        assertEquals(response.contentType(),"application/json");

        assertTrue(response.body().asString().contains("Not Found"));

        response.body().prettyPrint();



    }

}
