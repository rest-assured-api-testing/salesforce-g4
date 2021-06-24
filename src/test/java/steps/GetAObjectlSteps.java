package steps;

import api.ApiResponse;
import api.ApiRequestBuilder;
import api.ApiManager;
import api.IBuilderApiRequest;
import api.ApiRequest;
import api.ApiMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.account.Account;
import entities.account.AccountResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
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
    protected AccountResponse account = new AccountResponse();

    @Before
    public void createAccount() throws JsonProcessingException {
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
    }

    @Given("^I need \"([^\"]*)\" request$")
    public void i_need_something_request(String method) throws Throwable {
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I find \"([^\"]*)\" request$")
    public void i_find_something_request(String endpoint) throws Throwable {
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams("accountId", account.getId());
        apiResponse = ApiManager.execute(apiRequest);
    }

    @Then("^the response status coded is \"([^\"]*)\"$")
    public void the_response_status_coded_is_something(String strArg1) throws Throwable {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @After
    public void deleteAccount() {
        ApiRequest apiRequest = new ApiRequestBuilder()
                .endpoint("/Account/{accountId}")
                .pathParams("projectId", account.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
