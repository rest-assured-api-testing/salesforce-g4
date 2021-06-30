///**
// * Copyright (c) 2021 Fundacion Jala.
// *
// * This software is the confidential and proprietary information of Fundacion Jala
// * ("Confidential Information"). You shall not disclose such Confidential
// * Information and shall use it only in accordance with the terms of the
// * license agreement you entered into with Fundacion Jala
// *
// * @author Juan Pablo Gonzales Alvarado
// */
//
//package salesforce.steps;
//
//import api.ApiManager;
//import api.ApiMethod;
//import api.ApiRequest;
//import api.ApiResponse;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import entities.individual.Individual;
//import entities.individual.IndividualResponse;
//import generalsetting.ParameterEndPoints;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.apache.log4j.Logger;
//import org.springframework.http.HttpStatus;
//import org.testng.Assert;
//import utilities.ObjectInformation;
//
//import static utilities.JsonFormat.jsonConvert;
//
//public class IndividualGeneralSteps {
//    private Logger log = Logger.getLogger(getClass());
//    private ApiRequest apiRequest = new ApiRequest();
//    private ApiRequest apiRequestPatch = new ApiRequest();
//    private ApiResponse apiResponse;
//    private ObjectInformation objectInformation;
//    private IndividualResponse individualResponse;
//
//    public IndividualGeneralSteps(ObjectInformation objectInformation) {
//        log.info("GetIndividual constructor");
//        this.objectInformation = objectInformation;
//    }
//
//    @Given("^I build \"(POST|GET|DELETE|PATCH)\" request to individual")
//    public void iBuildRequestToxIndividual(String method) {
//        log.info("I build the request for individual");
//        apiRequest.setBaseUri(ParameterEndPoints.URL_BASE);
//        apiRequest.addHeaders(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER +
//                objectInformation.getToken());
//        apiRequest.setMethod(ApiMethod.valueOf(method));
//    }
//
//    @When("I use endpoint {string} request to individual with {string}")
//    public void iUseEndpointRequestToIndividuaWith(String endpoint, String keyPath) {
//        log.info("I build individual endpoint the request");
//        apiRequest.setEndpoint(endpoint);
//        apiRequest.addPathParams(keyPath, objectInformation.getId());
//    }
//
//    @And("I execute the request individual")
//    public void iExecuteTheRequestIndividua() {
//        log.info("I execute the Individual request");
//        apiResponse = ApiManager.execute(apiRequest);
//    }
//
//    @When("I use endpoint {string} request to individual with name {string}")
//    public void iUseEndpointRequestToIndividuaWithName(String endpoint, String name) throws JsonProcessingException {
//        log.info("I execute the request Individual post");
//        Individual individualCreate = new Individual(name);
//        apiRequest.setEndpoint(endpoint);
//        apiRequest.setBody(new ObjectMapper().writeValueAsString(individualCreate));
//        apiResponse = ApiManager.execute(apiRequest);
//        individualResponse=apiResponse.getBody(IndividualResponse.class);
//        objectInformation.setIdDelete(individualResponse.getId());
//    }
//
//    @And("I update individual {string} to {string}")
//    public void iUpdateIndividuaTheTo(String parameterToUpdate, String updateLastNme) throws JsonProcessingException {
//        log.info("I update the Individual");
//        Individual individualCreate = new Individual(updateLastNme);
//        apiRequest.setBody(new ObjectMapper().writeValueAsString(individualCreate));
//        apiResponse = ApiManager.execute(apiRequest);
//    }
//
//    @Then("the response status code should be {string} to individual")
//    public void theResponseStatusCodeShouldBeToIndividua(String statusCode) {
//        log.info("I verify status Individual response");
//        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.valueOf(statusCode).value());
//        apiResponse.getResponse().then().log().body();
//    }
//
//    @Then("^The schema to individual should be equals to \"([^\"]*)\"$")
//    public void theSchemaToIndividualShouldBeEqualsTo(String schema) {
//        log.info("I verify schema Individual");
//        apiResponse.validateBodySchema(schema);
//    }
//
//    @When("^I use endpoint \"([^\"]*)\" request to individual with \"([^\"]*)\" fail (.+)$")
//    public void iUseEndpointRequestToIndividuaWithFailBadId(String endpoint,String keyPath,String badId) {
//        log.info("I build individual fail endpoint with bad id");
//        apiRequest.setEndpoint(endpoint);
//        apiRequest.addPathParams(keyPath, badId);
//    }
//
//    @And("I execute the request individual fail")
//    public void iExecuteTheRequestIndividuaFail() {
//        log.info("I execute the Individual request Fail");
//        apiResponse = ApiManager.execute(apiRequest);
//    }
//
//    @Then("^the response status code fail should be (.+) to individual$")
//    public void theResponseStatusCodeFailShouldBeStatusToIndividua(String status) {
//        log.info("I verify status Individual fail response");
//        Assert.assertEquals(apiResponse.getStatusCode(), Integer.parseInt(status));
//        apiResponse.getResponse().then().log().body();
//    }
//
//    @When("^I use endpoint \"([^\"]*)\" request to individual with (.+) and (.+)$")
//    public void iUseEndpointRequestToIndividualWithApiNameAndValue(String endpoint,String apiName, String value) {
//        log.info("I create fail individual");
//        apiRequest.setBody(jsonConvert(apiName,value));
//        apiRequest.setEndpoint(endpoint);
//        apiResponse = ApiManager.execute(apiRequest);
//    }
//
//    @And("^I update individual the (.+) to (.+)$")
//    public void iUpdateIndividualTheApiNameToValue(String apiname, String value) {
//        log.info("I update the individual fail");
//        apiRequest.setBody(jsonConvert(apiname,value));
//        apiResponse = ApiManager.execute(apiRequest);
//    }
//}
