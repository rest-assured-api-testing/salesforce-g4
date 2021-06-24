package steps;

import api.ApiManager;
import api.ApiResponse;
import entities.Token;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class tokenSteps {
    private ApiResponse apiResponse;
    private Token token;

    @When("I execute toke request")
    public void iExecuteRequest(){
        apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
    }

    @Then("The new token should be type {string}")
    public void theResponseTypeShouldBe(String typeToken){
        Assert.assertEquals(token.getToken_type(), typeToken);
    }
}
