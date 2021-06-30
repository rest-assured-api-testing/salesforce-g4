/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
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
import entities.account.Account;
import entities.account.AccountResponse;
import entities.campaign.Campaign;
import entities.campaign.CampaignCreate;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import entities.group.Group;
import utilities.ObjectInformation;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import entities.product.Product;

import static utilities.JsonFormat.jsonConvert;

public class ProductGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiRequest apiRequestPatch = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;
    private ProductCreate productCreate;
    private CampaignCreate campaignCreate;
    private AccountResponse accountResponse;
    private ContactResponse contactResponse;

    public ProductGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation = objectInformation;
    }

    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request")
    public void iBuildRequestToProduct(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER
                + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request with {string}")
    public void iUseEndpointRequestToObjectWith(String endpoint, String keyPath) {
        log.info("I build endpoint the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
    }

    @And("I execute the request")
    public void iExecuteTheRequest() {
        log.info("I execute the request");
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to with name {string} to product")
    public void iUseEndpointRequestToObjectWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request post");
        Product projectCreate = new Product();
        projectCreate.setName(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(projectCreate));
        apiResponse = ApiManager.execute(apiRequest);
        productCreate = apiResponse.getBody(ProductCreate.class);
        objectInformation.setIdDelete(productCreate.getId());
    }

    @And("^I update the (.+) to (.+)$")
    public void iUpdateTheTo(String parameterToUpdate, String updateDate) {
        log.info("I update the product");
        apiRequest.setBody(jsonConvert(parameterToUpdate, updateDate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("The response status code should be {string}")
    public void theResponseStatusCodeShouldBeToProduct(String statusCode) {
        log.info("I verify status response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @And("The schema should be equals to {string}")
    public void theSchemaToProductShouldBeEqualsTo(String schema) {
        log.info("I verify schema");
        apiResponse.validateBodySchema(schema);
    }

    @When("^I use endpoint \"([^\"]*)\" request with \"([^\"]*)\" and (.+)$")
    public void iUseEndpointRequestToProductWithFailWrongId(String endpoint, String keyPath, String idCustomer) {
        log.info("I build account fail endpoint with bad id");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, idCustomer);
    }

    @Then("^the response status code fail should be (.+)$")
    public void theResponseStatusCodeShouldBeStatusToAccount(String status) {
        log.info("I verify status Account fail response");
        Assert.assertEquals(apiResponse.getStatusCode(), Integer.parseInt(status));
        apiResponse.getResponse().then().log().body();
    }

    @When("I use endpoint {string} request to with name {string} and visibility {string}")
    public void iUseEndpointRequestToObjectWithName(String endpoint, String name, String visibility)
            throws JsonProcessingException {
        log.info("I execute the request post");
        Group group = new Group();
        group.setName(name);
        group.setVisibility(visibility);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(group));
        apiResponse = ApiManager.execute(apiRequest);
        objectInformation.setIdDelete(apiResponse.getBody(Group.class).getId());
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

    @When("I use endpoint {string} request to account with name {string}")
    public void iUseEndpointRequestToAccountWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request Account post");
        Account accountCreate = new Account(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(accountCreate));
        apiResponse = ApiManager.execute(apiRequest);
        accountResponse = apiResponse.getBody(AccountResponse.class);
        objectInformation.setIdDelete(accountResponse.getId());
    }

    @When("^I use endpoint \"([^\"]*)\" request with (.+) and (.+) to fail$")
    public void iUseEndpointRequestToAccountWithApiName(String endpoint, String apiName, String value) {
        log.info("I create fail account");
        apiRequest.setBody(jsonConvert(apiName, value));
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
    }

    @And("I update account {string} to {string}")
    public void iUpdateTheToAccount(String parameterToUpdate, String updateDate) throws JsonProcessingException {
        log.info("I update the Account");
        Account accountCreate = new Account();
        accountCreate.setDescription(updateDate);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(accountCreate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to contact with name {string}")
    public void iUseEndpointRequestToContactWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request Contact post");
        Contact contactCreate = new Contact(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(contactCreate));
        apiResponse = ApiManager.execute(apiRequest);
        contactResponse = apiResponse.getBody(ContactResponse.class);
        objectInformation.setIdDelete(contactResponse.getId());
    }

    @And("I update contact {string} to {string}")
    public void iUpdateContactTheTo(String parameterToUpdate, String updateLastNme) throws JsonProcessingException {
        log.info("I update the Contact");
        Contact contactCreate = new Contact(updateLastNme);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(contactCreate));
        apiResponse = ApiManager.execute(apiRequest);
    }
}
