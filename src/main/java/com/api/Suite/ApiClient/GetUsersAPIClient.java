package com.api.Suite.ApiClient;

import com.api.Suite.constants.APIEndPoint;
import com.opensourceFramework.BaseAPIRequest;
import com.opensourceFramework.constants.ContentType;
import com.opensourceFramework.constants.MethodType;

public class GetUsersAPIClient extends BaseAPIRequest {
    public GetUsersAPIClient(String pageNumber){
        setMethod(MethodType.GET);
        setContentType(ContentType.JSON);
        setBaseUri(APIEndPoint.BaseUrl);
        setBasePath(APIEndPoint.Users);
        addHeader("accept","application/json");
        addQueryParam("page",pageNumber);;
    }
}
