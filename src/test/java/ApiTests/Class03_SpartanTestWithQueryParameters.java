package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Class03_SpartanTestWithQueryParameters {

    @BeforeClass
    public void setUpClass(){
       baseURI = "http://54.196.128.118:8000";
    }

    @Test
    public void QueryParam1(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "J")
                .when().get("/api/spartans/search");

        assertEquals(response.statusCode(),200);

        assertEquals(response.contentType(),"application/json");

        assertTrue(response.body().asString().contains("Female"));

        assertFalse(response.body().asString().contains("Male"));

        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();


    }
    /*@Ignore
    @Test
    public void QueryParam2(){
        //creating map for query params
        Map< String , Object> paramsMap = new HashMap<>();
        paramsMap.put("gender","Female");
        paramsMap.put("nameContains","J");

        //send request
        Response response = given().accept(ContentType.JSON)
                .and().queryParam(paramsMap)
                .when().get("/api/spartans/search");


        assertEquals(response.statusCode(),200);

        assertEquals(response.contentType(),"application/json");

        assertTrue(response.body().asString().contains("Female"));

        assertFalse(response.body().asString().contains("Male"));

        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();

    }*/





}
