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

package steps;

import api.ApiResponse;
import api.ApiRequestBuilder;
import api.ApiManager;
import api.ApiRequest;
import api.ApiMethod;
import entities.Token;
import entities.account.AccountResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class GetAllSteps {

    private ApiResponse apiResponse;

    protected ApiRequest apiRequest = new ApiRequest();
    protected ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    protected AccountResponse accountEndToEndResponse= new AccountResponse();

    @Before(value = "@GetAllObjects")
    public void setup(){
        apiResponse = ApiManager.executeToken();
        apiRequest = apiRequestBuilder
                .baseUri(ParameterEndPoints.URL_BASE+ParameterEndPoints.SOBJECTS)
                .headers("Authorization", "Bearer " + apiResponse.getBody(Token.class).getAccess_token())
                .build();
    }

    @Given("^I build \"([^\"]*)\" request$")
    public void i_build_something_request(String method) throws Throwable {
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute (.+) request$")
    public void i_execute_request(String sobject) throws Throwable {
        apiRequest.setEndpoint(sobject);
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("^the response status code should be \"([^\"]*)\"$")
    public void the_response_status_code_should_be_something(String strArg1) throws Throwable {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }
}
