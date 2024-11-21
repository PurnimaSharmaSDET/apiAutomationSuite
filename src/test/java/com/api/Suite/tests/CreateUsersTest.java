package com.api.Suite.tests;

import com.api.Suite.ApiClient.CreateUsers;
import com.api.Suite.helpers.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUsersTest extends BaseTest {

    @Test
    public void verifyCreateUsers(){
        String testName = "HomePage Validation";
        test = reports.startTest(testName);
        test.log(LogStatus.INFO,"i am Purnima");
        com.api.Suite.dto.CreateUsers usersDto=new com.api.Suite.dto.CreateUsers();
        usersDto.setJob("QA");
        usersDto.setName("shreenivash");
        CreateUsers createUsers= new CreateUsers(usersDto);
        Response response= createUsers.makeAPICall();
        test.log(LogStatus.INFO,response.getBody().prettyPrint());
        System.out.println(response);

    }
}
