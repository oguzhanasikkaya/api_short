package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class class09_SpartanPOSTRequest {

    @BeforeClass
    public void setUpClass(){
        baseURI = "http://54.196.128.118:8000";
    }

    @Test
    public void PostWithString(){

        Response post = given().accept(ContentType.JSON)
                                .and().contentType(ContentType.JSON)
                                .body("{\n" +
                                    "  \"gender\": \"Male\",\n" +
                                    "  \"name\": \"Cemal\",\n" +
                                    "  \"phone\": 5536667745\n" +
                                    "}")

                     .when().post("/api/spartans/");

        post.prettyPrint();

        //validation

        //verify status code is 201

        assertEquals(post.statusCode(),201);

        assertEquals(post.contentType(),"application/json");

        //verify success message
        assertEquals(post.path("success"),"A Spartan is Born!");

        //verify request body
        JsonPath json = post.jsonPath();

        assertEquals(json.getString("data.name"),"Cemal");
        assertEquals(json.getString("data.gender"),"Male");
        assertEquals(json.getLong("data.phone"),5536667745L);



    }


}
