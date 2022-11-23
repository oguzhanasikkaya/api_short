package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Class09_SpartanPOSTRequest {

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

    @Test
    public void PostWithMap(){

        //create a map to ve used a body for post request

        Map<String,Object> requestMap   = new HashMap<>();

        requestMap.put("name","CemalMap");
        requestMap.put("gender","Male");
        requestMap.put("phone",5536667745L);

        //create a request
        Response post = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(requestMap)

                .when().post("/api/spartans/");

        assertEquals(post.statusCode(),201);

        post.prettyPrint();




    }

    @Test
    public void POSTWithPojo(){
        //create spartan object and used as a body for post request
        Spartan spartan = new Spartan();
        spartan.setName("CemalPojo");
        spartan.setGender("Male");
        spartan.setPhone(5536667745L);

        Response response = given().accept(ContentType.JSON)
                                    .and().contentType(ContentType.JSON)
                                    .and().body(spartan)
                            .when().post("/api/spartans/");

        assertEquals(response.statusCode(),201);
        assertEquals(response.contentType(),"application/json");

        response.prettyPrint();

        //=============================get request==========================

        Response response2 = given().accept(ContentType.JSON)
                .pathParam("id", 110)
                .and().
                when().get("/api/spartans/{id}");

        Spartan spartanResponse = response2.body().as(Spartan.class);

        System.out.println(spartanResponse.toString());

    }


}
