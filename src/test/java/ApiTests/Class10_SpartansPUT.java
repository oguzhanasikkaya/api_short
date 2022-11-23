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

public class Class10_SpartansPUT {



    @BeforeClass
    public void setUpClass(){
        baseURI = "http://54.196.128.118:8000";


    }

    @Test
    public void putRequest(){
        //Different ways to send json body
        //-string
        //-using collection(map)
        //-pojo

        //using map
        Map<String,Object>putMap    = new HashMap<>();
        putMap.put("name","CemalPut");
        putMap.put("gender","Male");
        putMap.put("phone",8877423456L);


        //we gonna send request body with updated value, and content type header

        given().contentType(ContentType.JSON)
                .and().pathParam("id",108)
                .and().body(putMap).
        when().put("/api/spartans/{id}").
        then().assertThat().statusCode(204);


        Response response = given().accept(ContentType.JSON)
                                        .and().contentType(ContentType.JSON)
                                        .pathParam("id", 108).
                            when().get("/api/spartans/{id}");

        response.prettyPrint();


    }

    @Test
    public void patch(){

        Map<String,Object>patchMap    = new HashMap<>();
        patchMap.put("name","CemalPatch");



        //we gonna send request body with updated value, and content type header

        given().contentType(ContentType.JSON)
                .and().pathParam("id",101)
                .and().body(patchMap).
                when().patch("/api/spartans/{id}").
                then().assertThat().statusCode(204);

    }



}
