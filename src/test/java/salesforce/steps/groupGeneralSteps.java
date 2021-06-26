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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ObjectInformation;
import entities.group.Group;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;

import static utilities.JsonFormat.jsonConvert;

public class groupGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiRequest apiRequestPatch = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;


    public groupGeneralSteps(ObjectInformation objectInformation) {
        log.info("GroupGeneralSteps constructor");
        this.objectInformation = objectInformation;
    }


    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to group$")
    public void iBuildRequestToGroup(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to group with {string}")
    public void iUseEndpointRequestToObjectWith(String endpoint, String keyPath) {
        log.info("I build endpoint the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
    }

    @And("I execute the request group")
    public void iExecuteTheRequest() {
        log.info("I execute the request");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to with name {string} and visibility {string}")
    public void iUseEndpointRequestToObjectWithName(String endpoint, String name, String visibility)
            throws JsonProcessingException {
        log.info("I execute the request post");
        Group group=new Group();
        group.setName(name);
        group.setVisibility(visibility);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(group));
        apiResponse = ApiManager.execute(apiRequest);
        objectInformation.setIdDelete(apiResponse.getBody(Group.class).getId());
    }

    @And("^I update group the (.+) to (.+)$")
    public void iUpdateTheTo(String parameterToUpdate, String updateDate) {
        log.info("I update the product");

        apiRequest.setBody(jsonConvert(parameterToUpdate,updateDate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("the response status code should be {string} to group")
    public void theResponseStatusCodeShouldBeToProduct(String statusCode) {
        log.info("I verify status response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }
}
