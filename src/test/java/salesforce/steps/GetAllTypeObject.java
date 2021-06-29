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
import api.ApiRequestBuilder;
import entities.Token;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class GetAllTypeObject {
    private Logger log = Logger.getLogger(getClass());

    private ApiResponse apiResponse;

    protected ApiRequest apiRequest = new ApiRequest();
    protected ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();

    @Before(value = "@GetAll")
    public void setup() {
        log.info("I setup the token nad base URL");
        apiResponse = ApiManager.executeToken();
        apiRequest = apiRequestBuilder
                .baseUri(ParameterEndPoints.URL_BASE + ParameterEndPoints.SOBJECTS)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER
                        + apiResponse.getBody(Token.class).getAccess_token())
                .build();
    }

    @Given("I form a {string} request")
    public void iFormARequest(String method) {
        log.info("I form the request");
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute request to (.+)$")
    public void iExecuteRequestObject(String object) {
        System.out.println(object);
        log.info("I execute request object");
        apiRequest.setEndpoint(object);
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("^the status response should be (.+)$")
    public void theStatusResponseShouldBeResult(String result) {
        log.info("The status code is "+result);
        Assert.assertEquals(apiResponse.getStatusCode(), Integer.parseInt(result));
    }
}
