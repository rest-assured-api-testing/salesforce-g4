package steps;
import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.opportunity.Opportunity;
import entities.opportunity.OpportunityResponse;
import entities.product.Product;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class OpportunitySteps {

    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private OpportunityResponse opportunity = new OpportunityResponse();
    private String tokenUser;

    @Before(value = " @CreateOpportunity")
    public void generateToken() {
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
    }



    @Given("I create a opportunity with method {string}  with name {string}")
    public void iCreateOpportunityWithMethodSomethingWithNameSomething(String method, String name) throws JsonProcessingException {
        Opportunity opportunityTemp = new Opportunity("Opportunity90","2021-06-21","CloseDate");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + tokenUser);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(opportunityTemp));
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute \"([^\"]*)\" request to be create in a Opportunity$")
    public void iExecuteSomethingRequestToBeCreateInOpportunity(String endpoint) {
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
        opportunity = apiResponse.getBody(OpportunityResponse.class);

    }

    @Then("^The response status code should be successful \"([^\"]*)\" with opportunity created$")
    public void theResponseStatusCodeShouldBeSuccessfulSomethingWithOpportunityCreated(String strArg1) {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @After(value = " @CreateOpportunity")
    public void deleteOpportunity() {
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.OPPORTUNITY_TO_INTERACT)
                .pathParams(ParameterEndPoints.OPPORTUNITY_ID, opportunity.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }


}
