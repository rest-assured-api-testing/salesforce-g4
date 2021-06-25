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

import api.ApiResponse;
import api.ApiManager;
import api.ApiRequestBuilder;
import api.ApiRequest;
import api.ApiMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.product.Product;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class productSteps {
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private ProductCreate productCreate = new ProductCreate();
    private String tokenUser;

    @Before(value = "@CreateProduct")
    public void generateToken() {
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
    }

    @Given("I build {string} request with ID of project with name {string}")
    public void iBuildRequestWithIDOfProjectWithName(String method, String name) throws JsonProcessingException {
        Product product = new Product();
        product.setName(name);
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + tokenUser);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(product));
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I execute {string} request to be create in a product")
    public void iExecuteRequest(String endpoint) {
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
        productCreate = apiResponse.getBody(ProductCreate.class);
    }

    @Then("The response status code should be successful {string}")
    public void theResponseStatusCodeShouldBe(String statusCode) {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
        apiResponse.getResponse().then().log().body();
    }

    @After(value = "@CreateProduct")
    public void cleanRepository() {
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
