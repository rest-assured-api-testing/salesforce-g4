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
package tests;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.opportunity.Opportunity;
import entities.opportunity.OpportunityResponse;
import generalsetting.ParameterEndPoints;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpportunityTest extends BaseTestOpportunity{
    @Test
    public void get_all_contact_successful_200() {
        ApiRequest apiRequest = baseRequest().method(ApiMethod.GET).endpoint(ParameterEndPoints.OPPORTUNITY).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"createOpportunity","deleteOpportunity"})
    public void get_contact_successful_200(){
        ApiRequest apiRequest = baseRequest().method(ApiMethod.GET).endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, opportunityEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(),HttpStatus.SC_OK);
    }

    @Test(groups = {"deleteOpportunity"})
    public void create_contact_successful_200() throws JsonProcessingException {
        Opportunity opportunityTemp = new Opportunity("Opportunity40","2021-06-21","CloseDate");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.POST).endpoint(ParameterEndPoints.OPPORTUNITY)
                .body(new ObjectMapper().writeValueAsString(opportunityTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED);
        opportunityEndToEndResponse = response.getBody(OpportunityResponse.class);
    }

    @Test(groups = {"createOpportunity","deleteOpportunity"})
    public void update_contact_successful_201() throws JsonProcessingException {
        Opportunity opportunityTemp = new Opportunity("Opportunity Update","2021-06-21","CloseDate");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.PATCH).endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, opportunityEndToEndResponse.getId())
                .body(new ObjectMapper().writeValueAsString(opportunityTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = {"createOpportunity"})
    public void delete_contact_successful_204() throws JsonProcessingException{
        ApiRequest apiRequest = baseRequest().method(ApiMethod.DELETE).endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, opportunityEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
