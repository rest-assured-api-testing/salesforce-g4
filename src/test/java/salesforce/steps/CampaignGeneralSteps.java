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
import entities.campaign.Campaign;
import entities.campaign.CampaignCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import utilities.ObjectInformation;

import static utilities.JsonFormat.jsonConvert;

public class CampaignGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiRequest apiRequestPatch = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;
    private CampaignCreate campaignCreate;

    public CampaignGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation = objectInformation;
    }

    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to campaign")
    public void iBuildRequestToCampaign(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to campaign with {string}")
    public void iUseEndpointRequestToCampaignWith(String endpoint, String keyPath) {
        log.info("I build endpoint the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
    }

    @When("I use endpoint {string} to campaign request to with name {string}")
    public void iUseEndpointRequestToCampaignWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request post");
        Campaign campaignPost = new Campaign();
        campaignPost.setName(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(campaignPost));
        apiResponse = ApiManager.execute(apiRequest);
        campaignCreate = apiResponse.getBody(CampaignCreate.class);
        objectInformation.setIdDelete(campaignCreate.getId());
    }

    @And("I execute the request to campaign")
    public void iExecuteTheRequest() {
        log.info("I execute the request");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @And("^I update to campaign the (.+) to (.+)$")
    public void iUpdateTheTo(String parameterToUpdate, String updateDate) {
        log.info("I update the product");
        apiRequest.setBody(jsonConvert(parameterToUpdate, updateDate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("^I use endpoint \"([^\"]*)\" request to campaign with \"([^\"]*)\" and (.+)$")
    public void iUseEndpointRequestToProductWithFailWrongId(String endpoint, String keyPath, String idCustomer) {
        log.info("I build account fail endpoint with bad id");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, idCustomer);
    }

    @Then("the response status code should be {string} to campaign")
    public void theResponseStatusCodeShouldBeToCampaign(String statusCode) {
        log.info("I verify status response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @And("The schema to campaign should be equals to {string}")
    public void theSchemaToCampaignShouldBeEqualsTo(String schema) {
        log.info("I verify schema");
        apiResponse.validateBodySchema(schema);
    }
}
