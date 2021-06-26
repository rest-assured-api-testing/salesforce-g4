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
import entities.ObjectInformation;
import entities.Token;
import entities.opportunity.Opportunity;
import entities.opportunity.OpportunityResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class OpportunityHooks {

    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private OpportunityResponse opportunityResponse;
    private ObjectInformation objectInformation =new ObjectInformation();

    public OpportunityHooks(ObjectInformation objectInformation) {
        log.info("OpportunityHooks constructor");
        this.objectInformation=objectInformation;
    }

    @Before(value = "@GetOpportunity or @PostOpportunity or @DeleteOpportunity or @PatchOpportunity ", order = 1)
    public void generateToken() {
        log.info("Generate Token Opportunity");
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetOpportunity or @DeleteOpportunity or @PatchOpportunity", order = 2)
    public void createAccountHooks() throws JsonProcessingException {
        log.info("Create Opportunity");
        Opportunity contact = new Opportunity("Opportunity30","2021-06-21","CloseDate");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.OPPORTUNITY)
                .body(new ObjectMapper().writeValueAsString(contact))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        opportunityResponse = apiResponse.getBody(OpportunityResponse.class);
        objectInformation.setId(opportunityResponse.getId());
    }

    @After(value = "@GetOpportunity or @PatchOpportunity")
    public void deleteContactHooks() {
        log.info("Delete Opportunity Get or Patch");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, opportunityResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostOpportunity")
    public void cleanRepositoryPost() {
        log.info("Delete Opportunity Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
