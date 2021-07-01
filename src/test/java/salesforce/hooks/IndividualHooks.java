/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
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
import entities.Token;
import entities.individual.Individual;
import entities.individual.IndividualResponse;
import generalsetting.EndPoint;
import generalsetting.Param;
import generalsetting.Header;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import utilities.ObjectInformation;

public class IndividualHooks {

    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private IndividualResponse individualResponse;
    private ObjectInformation objectInformation = new ObjectInformation();

    public IndividualHooks(ObjectInformation objectInformation) {
        log.info("IndividualHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@GetIndividual or @PostIndividual or @DeleteIndividual or @PatchIndividual ", order = 1)
    public void generateToken() {
        log.info("Generate Token Individual");
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

    @Before(value = "@GetIndividual or @DeleteIndividual or @PatchIndividual", order = 2)
    public void createIndividualHooks() throws JsonProcessingException {
        log.info("Create Individual");
        Individual individual = new Individual("Individual test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.INDIVIDUAL.getEndPoint())
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
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.INDIVIDUAL.getEndPointInteract())
                .pathParams(EndPoint.INDIVIDUAL.toSetId(), individualResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostIndividual")
    public void cleanRepositoryPost() {
        log.info("Delete Individual Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.INDIVIDUAL.getEndPointInteract())
                .pathParams(EndPoint.INDIVIDUAL.toSetId(), objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
