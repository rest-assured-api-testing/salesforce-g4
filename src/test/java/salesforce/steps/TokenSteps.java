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
import org.testng.Assert;

public class TokenSteps {
    private ApiResponse apiResponse;
    private Token token;

    @When("I execute token request to get token bearer")
    public void iExecuteRequest(){
        apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
    }

    @Then("The new token should be type {string}")
    public void theResponseTypeShouldBe(String typeToken){
        Assert.assertEquals(token.getToken_type(), typeToken);
    }
}
