package salesforce.steps;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ObjectInformation;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import entities.product.Product;

public class productGeneralSteps {
    private Logger log = Logger.getLogger(getClass());
    private ApiRequest apiRequest = new ApiRequest();
    private ApiResponse apiResponse;
    private ObjectInformation objectInformation;
    private ProductCreate productCreate;

    public productGeneralSteps(ObjectInformation objectInformation) {
        log.info("GetObject constructor");
        this.objectInformation = objectInformation;
    }


    @Given("^I build \"(POST|GET|DELETE)\" request to product$")
    public void iBuildRequestToProduct(String method) {
        log.info("I build the request");
        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
        apiRequest.addHeaders("Authorization", "Bearer " + objectInformation.getToken());
        apiRequest.setMethod(ApiMethod.valueOf(method));
    }

    @When("I use endpoint {string} request to object with {string}")
    public void iUseEndpointRequestToObjectWith(String endpoint, String keyPath) {
        log.info("I execute the request");
        apiRequest.setEndpoint(endpoint);
        apiRequest.addPathParams(keyPath, objectInformation.getId());
        apiResponse = ApiManager.execute(apiRequest);
        ApiManager.execute(apiRequest);
    }

    @When("I use endpoint {string} request to with name {string}")
    public void iUseEndpointRequestToObjectWithName(String endpoint, String name) throws JsonProcessingException {
        log.info("I execute the request post");
        Product projectCreate = new Product();
        projectCreate.setName(name);

        apiRequest.setEndpoint(endpoint);
        apiRequest.setBody(new ObjectMapper().writeValueAsString(projectCreate));
        apiResponse = ApiManager.execute(apiRequest);
        productCreate=apiResponse.getBody(ProductCreate.class);
        objectInformation.setIdDelete(productCreate.getId());
    }

    @Then("the response status code should be {string} to product")
    public void theResponseStatusCodeShouldBeToProduct(String statusCode) {
        log.info("I verify status response");
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
        apiResponse.getResponse().then().log().body();
    }
}
