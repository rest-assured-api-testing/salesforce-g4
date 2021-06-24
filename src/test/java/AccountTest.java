/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */

import api.ApiManager;
import api.ApiMethod;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.account.Account;
import entities.account.AccountResponse;
import generalsetting.ParameterEndPoints;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTestAccount {

    @Test
    public void get_all_account_successful_200() {
        apiRequest.clearPathParams();
        apiRequest = apiRequestBuilder.method(ApiMethod.GET).endpoint(ParameterEndPoints.ACCOUNT).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"createAccount","deleteAccount"})
    public void getProjectWithStatusCode200(){
        apiRequest = apiRequestBuilder.method(ApiMethod.GET).endpoint("/Account/{accountId}")
                .pathParams("accountId", accountEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(),HttpStatus.SC_OK);
    }

    @Test(groups = {"deleteAccount"})
    public void createProjectWithStatusCode200() throws JsonProcessingException{
        Account accountTemp = new Account();
        accountTemp.setName("Account41");
        apiRequest = apiRequestBuilder.method(ApiMethod.POST).endpoint(ParameterEndPoints.ACCOUNT)
                .body(new ObjectMapper().writeValueAsString(accountTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED);
        accountEndToEndResponse = response.getBody(AccountResponse.class);
    }

    @Test(groups = {"createAccount","deleteAccount"})
    public void updateProjectWithStatusCode200() throws JsonProcessingException {
        Account accountTemp = new Account();
        accountTemp.setName("Account new Update");
        apiRequest = apiRequestBuilder.method(ApiMethod.PATCH).endpoint("/Account/{accountId}")
                .pathParams("accountId", accountEndToEndResponse.getId())
                .body(new ObjectMapper().writeValueAsString(accountTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = {"createAccount"})
    public void deleteProjectWithStatusCode200() {
        apiRequest = apiRequestBuilder.method(ApiMethod.DELETE).endpoint("/Account/{accountId}")
                .pathParams("accountId", accountEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
