package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class01_SpartanTests {

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


    @Test
    public void viewSpartan_Test2(){

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        Assert.assertEquals(response.statusCode(),200);

        Assert.assertTrue(response.body().asString().contains("Allen"));

    }

    @Test(testName = "head")
    public void viewSpartan_Test3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseUrl + "/api/spartans");


        Assert.assertEquals(response.statusCode(),200);

        Assert.assertEquals(response.contentType(),"application/json");


    }




}
