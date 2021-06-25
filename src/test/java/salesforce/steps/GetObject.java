/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package salesforce.steps;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import entities.ObjectInformation;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class GetObject {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;


    public GetObject(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation = objectInformation;
    }


    @Given("I build {string} request to any object")
    public void iBuildRequestToAnyObject(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute \"(.*?)\" request to object with \"(.*?)\"$")
    public void iExecuteRequest(String endpoint, String keyPath) {
        log.info("I execute the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
        apiResponse = ApiManager.execute(apiRequest);
        ApiManager.execute(apiRequest);
    }

    @Then("^the response status code should be \"(.*?)\" to object$")
    public void theResponseStatusCodeShouldBe(String statusCode) {
        log.info("I execute the request");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
        apiResponse.getResponse().then().log().body();
    }
}
