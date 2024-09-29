package com.api.Suite.tests;

import com.api.Suite.ApiClient.GetUsersAPIClient;
import com.api.Suite.helpers.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {
    @Test(description = "Sample Test info")
    public void getUsersTest(){
        ExtentReports extentReports = new ExtentReports();
        ExtentTest testNode = extentReports.createTest("Sample Test info");
        testNode.log(Status.INFO,"Adding Response");
        GetUsersAPIClient usersAPIClient= new GetUsersAPIClient("2");
        Response response= usersAPIClient.makeAPICall();
        System.out.println(response.getBody().prettyPrint());
        testNode.log(Status.PASS,response.prettyPrint());
        testNode.pass("sample");
//        test.log(Status.FAIL, "TEST CASE FAILED IS " +""); // to add name in extent report

    }

    @Test(description = "Sample Test info 2")
    public void getUsersTest2(){
        ExtentReports extentReports = new ExtentReports();
        ExtentTest testNode = extentReports.createTest("Sample Test info 2");
        testNode.log(Status.INFO,"Adding Response");
        GetUsersAPIClient usersAPIClient= new GetUsersAPIClient("2");
        Response response= usersAPIClient.makeAPICall();
        System.out.println(response.getBody().prettyPrint());
        testNode.log(Status.PASS,response.prettyPrint());

    }
}