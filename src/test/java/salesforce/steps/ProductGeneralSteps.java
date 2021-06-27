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

    public ProductGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation = objectInformation;
    }

    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to product$")
    public void iBuildRequestToProduct(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to product with {string}")
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

    @When("I use endpoint {string} request to with name {string}")
    public void iUseEndpointRequestToObjectWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request post");
        Product projectCreate = new Product();
        projectCreate.setName(name);
        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(projectCreate));
        apiResponse = ApiManager.execute(apiRequest);
        productCreate=apiResponse.getBody(ProductCreate.class);
        objectInformation.setIdDelete(productCreate.getId());
    }

    @And("^I update the (.+) to (.+)$")
    public void iUpdateTheTo(String parameterToUpdate, String updateDate) throws JsonProcessingException {
        log.info("I update the product");
        apiRequest.setBody(jsonConvert(parameterToUpdate,updateDate));
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("the response status code should be {string} to product")
    public void theResponseStatusCodeShouldBeToProduct(String statusCode) {
        log.info("I verify status response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @Then("The schema to product should be equals to {string}")
    public void theSchemaToProductShouldBeEqualsTo(String schema) {
        log.info("I verify schema");
        apiResponse.validateBodySchema(schema);
    }

    @Then("^The response status code should be (.+) to product$")
    public void theResponseStatusCodeShouldBeToProductFail(String statusCode) {
        log.info("I verify status response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @When("^I use endpoint \"([^\"]*)\" request to product with \"([^\"]*)\" and (.+)$")
    public void iUseEndpointRequestToProductWithFailWrongId(String endpoint,String keyPath,String idCustomer) {
        log.info("I build account fail endpoint with bad id");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, idCustomer);
    }
}
