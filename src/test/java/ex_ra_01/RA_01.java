package ex_ra_01;

import io.restassured.RestAssured;

public class RA_01 {
    public static void main(String[] args) {

        RestAssured.
                given().
                baseUri("https://restful-booker.herokuapp.com").
                basePath("/ping").
                when().get().then().statusCode(201);


    }


}


