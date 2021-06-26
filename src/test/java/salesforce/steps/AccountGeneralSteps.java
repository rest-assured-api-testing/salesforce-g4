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

package salesforce.steps;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ObjectInformation;
import entities.account.Account;
import entities.account.AccountResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;

public class AccountGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;
    private AccountResponse accountResponse;

    public AccountGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetObjectAccount constructor");
        this.objectInformation = objectInformation;
    }

    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to account$")
    public void iBuildRequestToAccount(String method) {
        log.info("I build the request for account");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to account with {string}")
    public void iUseEndpointRequestToAccountWith(String endpoint, String keyPath) {
        log.info("I build account endpoint the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
    }

    @And("I execute the request account")
    public void iExecuteTheRequestAccount() {
        log.info("I execute the Account request");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to account with name {string}")
    public void iUseEndpointRequestToObjectWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request Account post");
        Account accountCreate = new Account(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(accountCreate));
        apiResponse = ApiManager.execute(apiRequest);
        accountResponse=apiResponse.getBody(AccountResponse.class);
        objectInformation.setIdDelete(accountResponse.getId());
    }

    @And("I update account {string} to {string}")
    public void iUpdateTheTo(String parameterToUpdate, String updateDate) throws JsonProcessingException {
        log.info("I update the Account");
        Account accountCreate = new Account();
        accountCreate.setDescription(updateDate);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(accountCreate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("the response status code should be {string} to account")
    public void theResponseStatusCodeShouldBeToProduct(String statusCode) {
        log.info("I verify status Account response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }
}
