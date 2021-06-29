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

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.individual.Individual;
import entities.individual.IndividualResponse;
import generalsetting.ParameterEndPoints;
import generalsetting.ParameterUser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import utilities.ObjectInformation;

public class IndividualHooks {

    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private IndividualResponse individualResponse;
    private ObjectInformation objectInformation =new ObjectInformation();

    public IndividualHooks(ObjectInformation objectInformation) {
        log.info("IndividualHooks constructor");
        this.objectInformation=objectInformation;
    }

    @Before(value = "@GetIndividual or @PostIndividual or @DeleteIndividual or @PatchIndividual ", order = 1)
    public void generateToken() {
        log.info("Generate Token Individual");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .params(ParameterUser.USERNAME_KEY, ParameterUser.USERNAME_VALUE)
                .params(ParameterUser.PASSWORD_KEY, ParameterUser.PASSWORD_VALUE + ParameterUser.TOKEN_SECURITY)
                .params(ParameterUser.CLIENT_ID_KEY, ParameterUser.CLIENT_ID_VALUE)
                .params(ParameterUser.CLIENT_SECRET_KEY, ParameterUser.CLIENT_SECRET_VALUE)
                .params(ParameterUser.GRANT_TYPE_KEY, ParameterUser.GRANT_TYPE_VALUE)
                .headers(ParameterEndPoints.ACCEPT, ParameterEndPoints.APPLICATION_JSON)
                .headers(ParameterEndPoints.CONTENT_TYPE, ParameterEndPoints.X_WWW_FORM_URLENCODED)
                .baseUri(ParameterEndPoints.URL_TOKEN)
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.executeParam(apiRequest);
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetIndividual or @DeleteIndividual or @PatchIndividual", order = 2)
    public void createIndividualHooks() throws JsonProcessingException {
        log.info("Create Individual");
        Individual individual = new Individual("Individual test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser)
                .endpoint(ParameterEndPoints.INDIVIDUAL)
                .body(new ObjectMapper().writeValueAsString(individual))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        individualResponse = apiResponse.getBody(IndividualResponse.class);
        objectInformation.setId(individualResponse.getId());
    }

    @After(value = "@GetIndividual or @PatchIndividual")
    public void deleteIndividualHooks() {
        log.info("Delete Individual Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser)
                .endpoint(ParameterEndPoints.INDIVIDUAL_TO_INTERACT)
                .pathParams(ParameterEndPoints.INDIVIDUAL_ID, individualResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostIndividual")
    public void cleanRepositoryPost() {
        log.info("Delete Individual Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser)
                .endpoint(ParameterEndPoints.INDIVIDUAL_TO_INTERACT)
                .pathParams(ParameterEndPoints.INDIVIDUAL_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
