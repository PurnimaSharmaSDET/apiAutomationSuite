package com.api.Suite.tests;

import com.api.Suite.ApiClient.CreateUsers;
import com.api.Suite.helpers.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUsersTest extends BaseTest {

    @Test
    public void verifyCreateUsers(){
        com.api.Suite.dto.CreateUsers usersDto=new com.api.Suite.dto.CreateUsers();
        usersDto.setJob("QA");
        usersDto.setName("shreenivash");
        CreateUsers createUsers= new CreateUsers(usersDto);
        Response response= createUsers.makeAPICall();
        System.out.println(response);

    }
}
