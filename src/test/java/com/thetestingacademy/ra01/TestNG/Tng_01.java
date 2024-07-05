package com.thetestingacademy.ra01.TestNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Tng_01 {
        @Description("Verify get request request TNG1")
        @Test
        public void getRequest1()
        {
            RestAssured.
                    given().
                    baseUri("https://restful-booker.herokuapp.com").
                    basePath("/ping").
                    when().get().then().statusCode(201);
            System.out.println("CREATED");
        }
        @Description("Verify get request request TNG2")
        @Test
    public void getRequest2()
    {
        RestAssured.
                given().
                baseUri("https://restful-booker.herokuapp.com").
                basePath("/ping").
                when().get().then().statusCode(200);
        System.out.println("NOT CREATED");
    }
}
