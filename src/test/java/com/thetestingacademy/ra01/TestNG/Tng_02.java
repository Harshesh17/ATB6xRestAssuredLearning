package com.thetestingacademy.ra01.TestNG;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Tng_02 {

    @Description("Verify get request request 1")
    @Test
    public void get_Request1()
    {
        System.out.println("TC1");
    }
    @Description("Verify get request request 2")
    @Test
    public void get_Request2()
    {
        System.out.println("TC2");
    }
    @Description("Verify get request request 3")
    @Test
    public void get_Request3()
    {
        System.out.println("TC3");
    }
    @Description("Verify get request request 4")
    @Test
    public void get_Request4()
    {
        System.out.println("TC4");
    }
}
