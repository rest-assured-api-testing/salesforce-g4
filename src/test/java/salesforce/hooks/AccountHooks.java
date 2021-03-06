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

package salesforce.hooks;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import api.ApiRequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import salesforce.generalsetting.EndPoint;
import salesforce.generalsetting.Param;
import salesforce.generalsetting.Header;
import utilities.ObjectInformation;
import salesforce.entities.Token;
import salesforce.entities.account.Account;
import salesforce.entities.account.AccountResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class AccountHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private AccountResponse accountResponse;
    private ObjectInformation objectInformation = new ObjectInformation();

    public AccountHooks(ObjectInformation objectInformation) {
        log.info("AccountHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@GetAccount or @PostAccount or @DeleteAccount or @PatchAccount ", order = 1)
    public void generateToken() {
        log.info("Generate Token");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .params(Param.USERNAME.getKey(), Param.USERNAME.getValue())
                .params(Param.PASSWORD.getKey(), Param.PASSWORD.getValue())
                .params(Param.CLIENT_ID.getKey(), Param.CLIENT_ID.getValue())
                .params(Param.CLIENT_SECRET.getKey(), Param.CLIENT_SECRET.getValue())
                .params(Param.GRANT_TYPE.getKey(), Param.GRANT_TYPE.getValue())
                .headers(Header.ACCEPT.getValue(), Header.APPLICATION_JSON.getValue())
                .headers(Header.CONTENT_TYPE.getValue(), Header.X_WWW_FORM_URLENCODED.getValue())
                .baseUri(EndPoint.TOKEN.getEndPoint())
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.executeParam(apiRequest);
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetAccount or @DeleteAccount or @PatchAccount", order = 2)
    public void createAccountHooks() throws JsonProcessingException {
        log.info("Create Account hooks");
        Account account = new Account("account test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.ACCOUNT.getEndPoint())
                .body(new ObjectMapper().writeValueAsString(account))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        accountResponse = apiResponse.getBody(AccountResponse.class);
        objectInformation.setId(accountResponse.getId());
    }

    @After(value = "@GetAccount or @PatchAccount")
    public void deleteAccountHooks() {
        log.info("Delete Account hooks");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.ACCOUNT.getEndPointInteract())
                .pathParams(EndPoint.ACCOUNT.toSetId(), accountResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostAccount")
    public void cleanRepositoryPost() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.ACCOUNT.getEndPointInteract())
                .pathParams(EndPoint.ACCOUNT.toSetId(), objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
