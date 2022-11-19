package ApiTests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class Class07_SpartanJsonToCollections {

    @BeforeClass
    public void setUpClass(){
        baseURI = "http://54.196.128.118:8000";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .and().when().get("/api/spartans/{id}");

        //convert Json response to Java Collection(map)
        Map <String,Object> spartanMap = response.body().as(Map.class);

        System.out.println(spartanMap.get("name"));
        System.out.println(spartanMap.get("id"));
        System.out.println(spartanMap.get("phone"));




        Assert.assertEquals(spartanMap.get("name"),"Nona");
        Assert.assertEquals( spartanMap.get("phone"),7959094216d);


    }
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

      //  response.prettyPrint();
        //convert full json body to list of map
        List< Map< String,Object >   >listOfSpartans = response.body().as(List.class);

        //print all data of first spartan

        System.out.println(listOfSpartans.get(0));
        Map<String,Object> firstSpartan = listOfSpartans.get(0);
        System.out.println(firstSpartan.get("name"));
        System.out.println(listOfSpartans.get(0).get("id"));

        int counter = 1;
        for (Map<String, Object> map : listOfSpartans) {
            System.out.println(counter+" -->spartan " + map);
            counter++;
        }


    }

}
