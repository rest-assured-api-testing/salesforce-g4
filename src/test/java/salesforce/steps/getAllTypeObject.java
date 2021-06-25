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

import api.*;
import entities.Token;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class getAllTypeObject {
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
                .headers("Authorization", "Bearer " + apiResponse.getBody(Token.class).getAccess_token())
                .build();
    }

    @Given("I build {string} request.")
    public void iBuildRequest(String method) {
        log.info("I build the request");
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute (.+) request.$")
    public void iExecuteSObjectRequest(String sobject) {
        System.out.println(sobject);
        log.info("I execute the request");
        apiRequest.setEndpoint(sobject);
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("the response status code should be {string}.")
    public void theResponseStatusCodeShouldBe(String arg0) {
        log.info("I execute the request");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }
}
