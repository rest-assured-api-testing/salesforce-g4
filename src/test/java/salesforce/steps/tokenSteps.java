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
import api.ApiResponse;
import entities.Token;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;

public class tokenSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiResponse apiResponse;
    private Token token;

    @When("I execute token request")
    public void iExecuteRequest(){
        log.info("I execute token request");
        apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
    }

    @Then("The new token should be type {string}")
    public void theResponseTypeShouldBe(String typeToken){
        log.info("I verify type token");
        Assert.assertEquals(token.getToken_type(), typeToken);
    }

    @Then("The response status code should be {string} to token")
    public void theResponseStatusCodeShouldBeToToken(String statusCode) {
        log.info("I verify status response to token");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }

    @Then("The response token should be schema {string}")
    public void theResponseStatusCodeShouldBeToProduct(String schema) {
        log.info("I verify schema to token");
        apiResponse.validateBodySchema(schema);
    }
}
