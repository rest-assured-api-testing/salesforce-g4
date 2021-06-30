/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */

package salesforce.hooks;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import api.ApiRequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import generalsetting.ParameterUser;
import utilities.ObjectInformation;
import entities.Token;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class ContactHooks {

    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private ContactResponse contactResponse;
    private ObjectInformation objectInformation =new ObjectInformation();

    public ContactHooks(ObjectInformation objectInformation) {
        log.info("ContactHooks constructor");
        this.objectInformation=objectInformation;
    }

    @Before(value = "@GetContact or @PostContact or @DeleteContact or @PatchContact ", order = 1)
    public void generateToken() {
        log.info("Generate Token Contact");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .params(ParameterUser.USERNAME_KEY, ParameterUser.USERNAME_VALUE)
                .params(ParameterUser.PASSWORD_KEY, ParameterUser.PASSWORD_VALUE + ParameterUser.TOKEN_SECURITY)
                .params(ParameterUser.CLIENT_ID_KEY, ParameterUser.CLIENT_ID_VALUE)
                .params(ParameterUser.CLIENT_SECRET_KEY, ParameterUser.CLIENT_SECRET_VALUE)
                .params(ParameterUser.GRANT_TYPE_KEY, ParameterUser.GRANT_TYPE_VALUE)
                .headers(ParameterEndPoints.ACCEPT, ParameterEndPoints.APPLICATION_JSON)
                .headers(ParameterEndPoints.CONTENT_TYPE, ParameterEndPoints.X_WWW_FORM_URLENCODED)
                .baseUri(ParameterEndPoints.URL_TOKEN)
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.executeParam(apiRequest);
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetContact or @DeleteContact or @PatchContact", order = 2)
    public void createAccountHooks() throws JsonProcessingException {
        log.info("Create Contact");
        Contact contact = new Contact("contact test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser)
                .endpoint(ParameterEndPoints.CONTACT)
                .body(new ObjectMapper().writeValueAsString(contact))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        contactResponse = apiResponse.getBody(ContactResponse.class);
        objectInformation.setId(contactResponse.getId());
    }

    @After(value = "@GetContact or @PatchContact")
    public void deleteContactHooks() {
        log.info("Delete Contact Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser)
                .endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contactResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostContact")
    public void cleanRepositoryPost() {
        log.info("Delete Contact Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser)
                .endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
