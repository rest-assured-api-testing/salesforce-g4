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
import api.ApiRequestBuilder;
import entities.Token;
import generalsetting.ParameterEndPoints;
import generalsetting.ParameterUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;

public class TokenSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiResponse apiResponse;
    private Token token;

    @Given("I build {string} request to token")
    public void iBuildRequestToToken(String method) {
        log.info("I build the request");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .params(ParameterUser.USERNAME_KEY, ParameterUser.USERNAME_VALUE)
                .params(ParameterUser.PASSWORD_KEY, ParameterUser.PASSWORD_VALUE + ParameterUser.TOKEN_SECURITY)
                .params(ParameterUser.CLIENT_ID_KEY, ParameterUser.CLIENT_ID_VALUE)
                .params(ParameterUser.CLIENT_SECRET_KEY, ParameterUser.CLIENT_SECRET_VALUE)
                .params(ParameterUser.GRANT_TYPE_KEY, ParameterUser.GRANT_TYPE_VALUE)
                .headers(ParameterEndPoints.ACCEPT, ParameterEndPoints.APPLICATION_JSON)
                .headers(ParameterEndPoints.CONTENT_TYPE, ParameterEndPoints.X_WWW_FORM_URLENCODED)
                .baseUri(ParameterEndPoints.URL_TOKEN)
                .method(ApiMethod.valueOf(method))
                .build();
        apiResponse = ApiManager.executeParam(apiRequest);
    }

    @When("I execute token request")
    public void iExecuteRequest() {
        log.info("I execute token request");
        apiResponse = ApiManager.executeToken();
        token = apiResponse.getBody(Token.class);
    }

    @And("The new token should be type {string}")
    public void theResponseTypeShouldBe(String typeToken) {
        log.info("I verify type token");
        Assert.assertEquals(token.getToken_type(), typeToken);
    }

    @Then("The response status code should be {string} to token")
    public void theResponseStatusCodeShouldBeToToken(String statusCode) {
        log.info("I verify status response to token");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @And("The response token should be schema {string}")
    public void theResponseStatusCodeShouldBeToProduct(String schema) {
        log.info("I verify schema to token");
        apiResponse.validateBodySchema(schema);
    }
}
