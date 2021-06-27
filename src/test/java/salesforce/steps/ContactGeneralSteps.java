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
import utilities.ObjectInformation;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import static utilities.JsonFormat.jsonConvert;

public class ContactGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiRequest apiRequestPatch = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;
    private ContactResponse contactResponse;

    public ContactGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation = objectInformation;
    }

    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to contact")
    public void iBuildRequestToContact(String method) {
        log.info("I build the request for contact");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to contact with {string}")
    public void iUseEndpointRequestToContactWith(String endpoint, String keyPath) {
        log.info("I build contact endpoint the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
    }

    @And("I execute the request contact")
    public void iExecuteTheRequestContact() {
        log.info("I execute the Contact request");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to contact with name {string}")
    public void iUseEndpointRequestToContactWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request Contact post");
        Contact contactCreate = new Contact(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(contactCreate));
        apiResponse = ApiManager.execute(apiRequest);
        contactResponse=apiResponse.getBody(ContactResponse.class);
        objectInformation.setIdDelete(contactResponse.getId());
    }

    @And("I update contact {string} to {string}")
    public void iUpdateContactTheTo(String parameterToUpdate, String updateLastNme) throws JsonProcessingException {
        log.info("I update the Contact");
        Contact contactCreate = new Contact(updateLastNme);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(contactCreate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("the response status code should be {string} to contact")
    public void theResponseStatusCodeShouldBeToContact(String statusCode) {
        log.info("I verify status Contact response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @Then("^The schema to contact should be equals to \"([^\"]*)\"$")
    public void theSchemaToContactShouldBeEqualsTo(String schema) {
        log.info("I verify schema Contact");
        apiResponse.validateBodySchema(schema);
    }

    @When("^I use endpoint \"([^\"]*)\" request to contact with \"([^\"]*)\" fail (.+)$")
    public void iUseEndpointRequestToContactWithFailBadId(String endpoint,String keyPath,String badId) {
        log.info("I build contact fail endpoint with bad id");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, badId);
    }

    @And("I execute the request contact fail")
    public void iExecuteTheRequestContactFail() {
        log.info("I execute the Contact request Fail");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("^the response status code fail should be (.+) to contact$")
    public void theResponseStatusCodeFailShouldBeStatusToContact(String status) {
        log.info("I verify status Contact fail response");
        Assert.assertEquals(apiResponse.getStatusCode(), Integer.parseInt(status));
        apiResponse.getResponse().then().log().body();
    }

    @When("^I use endpoint \"([^\"]*)\" request to contact with (.+) and (.+)$")
    public void iUseEndpointRequestToContactWithApiNameAndValue(String endpoint,String apiName, String value) {
        log.info("I create fail contact");
        apiRequest.setBody(jsonConvert(apiName,value));
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
    }

    @And("^I update contact the (.+) to (.+)$")
    public void iUpdateContactTheApiNameToValue(String apiname, String value) {
        log.info("I update the account fail");
        apiRequest.setBody(jsonConvert(apiname,value));
        apiResponse = ApiManager.execute(apiRequest);
    }
}
