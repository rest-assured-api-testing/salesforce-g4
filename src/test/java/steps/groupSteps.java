package steps;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.group.Group;
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

public class groupSteps {
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private Group group = new Group();
    private String tokenUser;

    @Before
    public void generateToken() {
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
    }

    @Given("I build {string} request to create group with name {string} and visibility {string}")
    public void iBuildRequestWithIDOfProjectWithName(String method, String name, String visibility) throws JsonProcessingException {
        Group group=new Group();
        group.setName(name);
        group.setVisibility(visibility);
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + tokenUser);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(group));
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I execute {string} request to create a group")
    public void iExecuteRequest(String endpoint) {
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
        group = apiResponse.getBody(Group.class);
    }

    @Then("the response status code should be successful in order to be {string}")
    public void theResponseStatusCodeShouldBe(String statusCode) {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
        apiResponse.getResponse().then().log().body();
    }

    @After
    public void cleanRepository() {
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.GROUP_TO_INTERACT)
                .pathParams(ParameterEndPoints.GROUP_ID,group.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
