package ApiTests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Class08_SpartanTestWitPOJODeserization {

    @BeforeClass
    public void setUpClass(){
        baseURI = "http://54.196.128.118:8000";
    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");


        //how to convert json response to our spartan class
        Spartan spartan1 = response.body().as(Spartan.class);

        System.out.println(spartan1.toString());

        Assert.assertEquals(spartan1.getName(),"Meta");
        Assert.assertEquals(spartan1.getId(),15);
        Assert.assertEquals(spartan1.getGender(),"Female");
        Assert.assertEquals(spartan1.getPhone(), 1938695106);


    }


    @Test
    public void gsonExapmle(){

        Gson gson = new Gson();

        String myJsonBody  = "{\n" +
                "    \"id\": 11,\n" +
                "    \"name\": \"Nona\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 7959094216\n" +
                "}" ;

        //Using gson method do de serialize out json body

        Spartan spartanMeta = gson.fromJson(myJsonBody, Spartan.class);

        System.out.println(spartanMeta.toString());

        //serialization Java objext ---> Json body

        Spartan spartan = new Spartan(102,"Ahmet","Male",5510046998l);

        //converting custom class to json

        String jsonBody = gson.toJson(spartan);

        System.out.println(jsonBody);


    }
}
