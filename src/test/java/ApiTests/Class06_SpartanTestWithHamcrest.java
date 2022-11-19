package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class06_SpartanTestWithHamcrest {

    @BeforeClass
    public void setUpClass(){
        baseURI = "http://54.196.128.118:8000";
    }

    /*
    "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106
     */

    @Test
    public  void  test1(){

                 given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                 //response part
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }
    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(15)
                                        ,"name",Matchers.equalTo("Meta")
                                                ,"gender",Matchers.equalTo("Female")
                                                ,"phone",Matchers.equalTo(1938695106));

    }


}
