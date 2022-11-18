package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.*;

public class Class04_SpartanTestWithPathMethod {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI = "http://54.196.128.118:8000";
    }
/*
    "id": 10,
    "name": "Lorenza",
    "gender": "Female",
    "phone": 3312820936
 */

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        Assert.assertEquals(response.contentType(),"application/json");


        System.out.println(response.body().path("id").toString());
        System.out.println(response.body().path("name").toString());
        System.out.println(response.body().path("gender").toString());
        System.out.println(response.path("phone").toString());

        int id = response.path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        Assert.assertEquals(id,10);
        Assert.assertEquals(name,"Lorenza");
        Assert.assertEquals(gender,"Female");
        Assert.assertEquals(phone,3312820936l);



    }


    @Test
    public void test2(){
        Response response = get("/api/spartans");

        //extract first id

        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        //extract firstname
        String firstName = response.path("name[0]");
        System.out.println("firstName = " + firstName);

        //extract last firstname
        String last1stName = response.path("name[-1]");
        System.out.println("last1stName = " + last1stName);

        //extract all firstNames and print them

       List<String> names = response.path("name");
        System.out.println(names);
        System.out.println(names.size());

       List<Objects>phoneNumbers = response.body().path("phone");
        System.out.println(phoneNumbers);

        for (Objects phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }



    }

}
