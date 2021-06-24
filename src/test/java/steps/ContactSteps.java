package steps;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class ContactSteps {
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private ContactResponse contact = new ContactResponse();
    private String tokenUser;

    @Before
    public void generateToken() {
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
    }

    @Given("I create a contact with method {string} with name {string}")
    public void iBuildRequestWithIDOfProjectWithName(String method, String name) throws JsonProcessingException {
        Contact contact = new Contact();
        contact.setName(name);
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + tokenUser);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(contact));
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute \"([^\"]*)\" request to be create in a Contact$")
    public void iExecuteRequest(String endpoint) {
        apiRequest.setEndpoint(endpoint);
        apiResponse = ApiManager.execute(apiRequest);
        contact = apiResponse.getBody(ContactResponse.class);
    }

    @Then("^The response status code should be successful \"([^\"]*)\" with contact created$")
    public void theResponseStatusCodeShouldBe(String statusCode) {
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    @After
    public void cleanRepository() {
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contact.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
