package steps;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.account.Account;
import entities.account.AccountResponse;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import entities.opportunity.Opportunity;
import entities.opportunity.OpportunityResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class GetAObjectlSteps {

    private ApiResponse apiResponse;
    protected ApiRequest apiRequest = new ApiRequest();
    protected ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    protected AccountResponse accountEndToEndResponse= new AccountResponse();

    protected AccountResponse account = new AccountResponse();
    protected ContactResponse contact = new ContactResponse();
    protected OpportunityResponse opportunity = new OpportunityResponse();

    @Before
    public void setup() throws JsonProcessingException {
        apiResponse = ApiManager.executeToken();
        apiRequest = apiRequestBuilder
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + apiResponse.getBody(Token.class).getAccess_token())
                .build();
        Account accountTemp = new Account("account10");
        apiRequest.setEndpoint(ParameterEndPoints.ACCOUNT);
        apiRequest.setMethod(ApiMethod.POST);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(accountTemp));
        account = ApiManager.execute(apiRequest).getBody(AccountResponse.class);

        Contact contactTemp = new Contact("contact10");
        apiRequest.setEndpoint(ParameterEndPoints.CONTACT);
        apiRequest.setMethod(ApiMethod.POST);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(contactTemp));
        contact = ApiManager.execute(apiRequest).getBody(ContactResponse.class);

        Opportunity opportunityTemp = new Opportunity("opportunity10","2021-06-21","CloseDate");
        apiRequest.setEndpoint(ParameterEndPoints.OPPORTUNITY);
        apiRequest.setMethod(ApiMethod.POST);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(opportunityTemp));
        opportunity = ApiManager.execute(apiRequest).getBody(OpportunityResponse.class);


    }

    @Given("^I need \"([^\"]*)\" request$")
    public void i_need_something_request(String method) throws Throwable {
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I find (.+)/{objectId} request$")
    public void i_find_objectid_request(String sobject) throws Throwable {
        throw new PendingException();
    }

    @Then("^the response status coded is \"([^\"]*)\"$")
    public void the_response_status_coded_is_something(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @When("I find <SObject>\\/\\{objectId} request")
    public void iFindSObjectObjectIdRequest(String valor) {
    }

    @When("I find <SObject>\\/\\{objectId} request")
    public void iFindSObjectObjectIdRequest() {
    }
}
