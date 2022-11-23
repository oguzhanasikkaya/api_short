package ApiTests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class11_SpartanDelete {

    @BeforeClass
    public void setUpClass(){
        baseURI = "http://54.196.128.118:8000";


    }

    @Test
    public void test1(){

                given().pathParam("id", 109).
                when().delete("/api/spartans/{id}").
                then().assertThat().statusCode(204);

                given().pathParam("id", 109).
                when().delete("/api/spartans/{id}").
                then().assertThat().statusCode(404);

    }

}
