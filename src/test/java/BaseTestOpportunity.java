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

import api.ApiResponse;
import api.ApiRequestBuilder;
import api.ApiManager;
import api.IBuilderApiRequest;
import api.ApiRequest;
import api.ApiMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.opportunity.Opportunity;
import entities.opportunity.OpportunityResponse;
import generalsetting.ParameterEndPoints;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestOpportunity {

    protected OpportunityResponse opportunityEndToEndResponse= new OpportunityResponse();

    public IBuilderApiRequest baseRequest() {
        ApiResponse response = ApiManager.executeToken();
        return new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + response.getBody(Token.class).getAccess_token());
    }


    @BeforeMethod(onlyForGroups = "createOpportunity")
    public void createdContactBefore() throws JsonProcessingException {
        Opportunity opportunityTemp = new Opportunity("Opportunity30","2021-06-21","CloseDate");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.POST).endpoint(ParameterEndPoints.OPPORTUNITY)
                .body(new ObjectMapper().writeValueAsString(opportunityTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        opportunityEndToEndResponse = response.getBody(OpportunityResponse.class);
    }

    @AfterMethod(onlyForGroups = "deleteOpportunity")
    public void deleteContactAfter() {
        ApiRequest apiRequest = baseRequest().method(ApiMethod.DELETE).endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, opportunityEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}


