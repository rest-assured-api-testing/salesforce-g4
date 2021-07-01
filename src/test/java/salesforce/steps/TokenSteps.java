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
import salesforce.entities.Token;
import salesforce.generalsetting.EndPoint;
import salesforce.generalsetting.Param;
import salesforce.generalsetting.Header;
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
    private ApiRequest apiRequest;
    private Token token;

    @Given("I build {string} request to token")
    public void iBuildRequestToToken(String method) {
        log.info("I build the request");
        apiRequest = new ApiRequestBuilder()
                .params(Param.USERNAME.getKey(), Param.USERNAME.getValue())
                .params(Param.PASSWORD.getKey(), Param.PASSWORD.getValue())
                .params(Param.CLIENT_ID.getKey(), Param.CLIENT_ID.getValue())
                .params(Param.CLIENT_SECRET.getKey(), Param.CLIENT_SECRET.getValue())
                .params(Param.GRANT_TYPE.getKey(), Param.GRANT_TYPE.getValue())
                .headers(Header.ACCEPT.getValue(), Header.APPLICATION_JSON.getValue())
                .headers(Header.CONTENT_TYPE.getValue(), Header.X_WWW_FORM_URLENCODED.getValue())
                .baseUri(EndPoint.TOKEN.getEndPoint())
                .method(ApiMethod.valueOf(method))
                .build();

    }

    @When("I execute token request")
    public void iExecuteRequest() {
        log.info("I execute token request");
        apiResponse = ApiManager.executeParam(apiRequest);
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
