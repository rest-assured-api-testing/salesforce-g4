import api.*;
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
        Opportunity opportunityTemp = new Opportunity();
        opportunityTemp.setName("Opportunity30");
        opportunityTemp.setCloseDate("2021-06-21");
        opportunityTemp.setStageName("CloseDate");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.POST).endpoint(ParameterEndPoints.OPPORTUNITY)
                .body(new ObjectMapper().writeValueAsString(opportunityTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        opportunityEndToEndResponse = response.getBody(OpportunityResponse.class);
    }

    @AfterMethod(onlyForGroups = "deleteOpportunity")
    public void deleteContactAfter() { ;
        ApiRequest apiRequest = baseRequest().method(ApiMethod.DELETE).endpoint("/Opportunity/{opportunityId}")
                .pathParams("opportunityId", opportunityEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}


