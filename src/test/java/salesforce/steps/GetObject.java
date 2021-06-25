package salesforce.steps;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import entities.ObjectInformation;
import entities.Token;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class GetObject {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private String tokenUser;
    private String idObject;
    private ProductCreate productCreate;
    private Token token;
    private ObjectInformation objectInformation;

//    public GetObject(Token token, ProductCreate productCreate) {
//        log.info("GetObject constructor");
//        this.token = token;
//        this.productCreate=productCreate;
//    }

    public GetObject(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation=objectInformation;
    }


    @Given("I build {string} request to any object")
    public void iBuildRequestToAnyObject(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("^I execute \"(.*?)\" request to object with \"(.*?)\"$")
    public void iExecuteRequest(String endpoint, String keyPath) {
        log.info("I execute the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
        apiResponse = ApiManager.execute(apiRequest);
        ApiManager.execute(apiRequest);
    }

    @Then("^the response status code should be \"(.*?)\" to object$")
    public void theResponseStatusCodeShouldBe(String statusCode) {
        log.info("I execute the request");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
        apiResponse.getResponse().then().log().body();
    }
}
