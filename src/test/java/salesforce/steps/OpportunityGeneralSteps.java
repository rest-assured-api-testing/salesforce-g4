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
import entities.opportunity.Opportunity;
import entities.opportunity.OpportunityResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;


public class OpportunityGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiRequest apiRequestPatch = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;
    private OpportunityResponse opportunityResponse;

    public OpportunityGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetOpportunity constructor");
        this.objectInformation = objectInformation;
    }


    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to opportunity")
    public void iBuildRequestToOpportunity(String method) {
        log.info("I build the request for opportunity");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to opportunity with {string}")
    public void iUseEndpointRequestToOpportunityWith(String endpoint, String keyPath) {
        log.info("I build opportunity endpoint the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
    }

    @And("I execute the request opportunity")
    public void iExecuteTheRequestOpportunity() {
        log.info("I execute the Opportunity request");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to opportunity with name {string}")
    public void iUseEndpointRequestToOpportunityWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request Opportunity post");
        Opportunity opportunityCreate = new Opportunity("Opportunity30","2021-06-21","CloseDate");
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(opportunityCreate));
        apiResponse = ApiManager.execute(apiRequest);
        opportunityResponse=apiResponse.getBody(OpportunityResponse.class);
        objectInformation.setIdDelete(opportunityResponse.getId());
    }

    @And("I update opportunity {string} to {string}")
    public void iUpdateOpportunityTheTo(String parameterToUpdate, String updateLastNme) throws JsonProcessingException {
        log.info("I update the Opportunity");
        Opportunity opportunityCreate = new Opportunity("New Opportunity30","2021-06-21","CloseDate");
        apiRequest.setBody(new ObjectMapper().writeValueAsString(opportunityCreate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("the response status code should be {string} to opportunity")
    public void theResponseStatusCodeShouldBeToOpportunity(String statusCode) {
        log.info("I verify status Opportunity response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }


}