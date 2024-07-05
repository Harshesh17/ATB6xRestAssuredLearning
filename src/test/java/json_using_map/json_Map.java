package json_using_map;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class json_Map {
    @Test
    public void testPOSTReq(){

        Map<String ,Object> jsonbodyusingMap = new HashMap<>();
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        jsonbodyusingMap.put("firstname",firstname);
        jsonbodyusingMap.put("lastname", lastname);
        jsonbodyusingMap.put("totalprice",faker.random().nextInt(1000));
        jsonbodyusingMap.put("depositpaid",faker.random().nextBoolean());

        Map<String,Object> bookingdatesMap = new LinkedHashMap<>();
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2018-01-05");

        jsonbodyusingMap.put("bookingdates",bookingdatesMap);
        jsonbodyusingMap.put("addtionalneeds","Breakfast");


        System.out.println(jsonbodyusingMap);

        RequestSpecification r = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;
            String BASE_URL = "https://restful-booker.herokuapp.com";
            String BASE_PATH = "/booking";
            r.baseUri(BASE_URL);
            r.basePath(BASE_PATH);
            r.contentType(ContentType.JSON).log().all();
            r.body(jsonbodyusingMap);
            response = r.when().log().all().post();
            String responseString = response.asString();
            System.out.println(responseString);
            validatableResponse = response.then();
            validatableResponse.statusCode(200);





        }

    }




