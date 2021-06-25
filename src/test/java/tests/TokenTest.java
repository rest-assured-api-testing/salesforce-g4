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
package tests;

import api.ApiResponse;
import api.ApiManager;
import entities.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenTest {
    private Token token;

    @Test
    public void statusToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        Assert.assertEquals(apiResponse.getStatusCode(), 200);
    }

    @Test
    public void getToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
        Assert.assertEquals(apiResponse.getStatusCode(), 200);
    }

    @Test
    public void verifyTokenSchema_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
        apiResponse.validateBodySchema("schemas/token.json");
    }
}

