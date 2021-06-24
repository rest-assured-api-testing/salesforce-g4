package steps;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.account.Account;
import entities.account.AccountResponse;
import entities.group.Group;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class AccountSteps {
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private AccountResponse account = new AccountResponse();
    private String tokenUser;

    @Before(value = " @CreateAccount")
    public void generateToken() {
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
    }
    @Given("^I create a product with method \"([^\"]*)\"  with name \"([^\"]*)\"$")
    public void iCreateAProductWithMethodSomethingWithNameSomething(String method, String name)throws JsonProcessingException {
        Account accountTemp =new Account();
        accountTemp .setName(name);
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + tokenUser);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(accountTemp ));
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute \"([^\"]*)\" request to be create in a Account$")
    public void iExecuteSomethingRequestToBeCreateInAccount(String endpoint) {
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
        account = apiResponse.getBody(AccountResponse.class);
    }

    @Then("^The response status code should be successful \"([^\"]*)\" with account created$")
    public void the_response_status_code_should_be_successful_something_with_account_created(String statusCode) {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @After(value = " @CreateAccount")
    public void deleteAccount() {
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.ACCOUNT_TO_INTERACT)
                .pathParams(ParameterEndPoints.ACCOUNT_ID,account.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

}
