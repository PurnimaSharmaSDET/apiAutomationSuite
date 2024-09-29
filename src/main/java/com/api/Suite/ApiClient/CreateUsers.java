package com.api.Suite.ApiClient;

import com.api.Suite.constants.APIEndPoint;
import com.opensourceFramework.BaseAPIRequest;
import com.opensourceFramework.constants.ContentType;
import com.opensourceFramework.constants.MethodType;

public class CreateUsers extends BaseAPIRequest {
    public CreateUsers(com.api.Suite.dto.CreateUsers users) {
        setMethod(MethodType.POST);
        setContentType(ContentType.JSON);
        setBaseUri(APIEndPoint.BaseUrl);
        setBasePath(APIEndPoint.Users);
        setBody(users);
        addHeader("accept", "application/json");
    }
}
