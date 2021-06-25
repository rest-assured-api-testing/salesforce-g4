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

import api.ApiResponse;
import api.ApiRequestBuilder;
import api.ApiManager;
import api.IBuilderApiRequest;
import api.ApiRequest;
import api.ApiMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import generalsetting.ParameterEndPoints;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestContact {

    protected ContactResponse contactEndToEndResponse= new ContactResponse();

    public IBuilderApiRequest baseRequest() {
        ApiResponse response = ApiManager.executeToken();
        return new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + response.getBody(Token.class).getAccess_token());
    }


    @BeforeMethod(onlyForGroups = "createContact")
    public void createdContactBefore() throws JsonProcessingException {
        Contact contactTemp = new Contact("Contact30");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.POST).endpoint(ParameterEndPoints.CONTACT)
                .body(new ObjectMapper().writeValueAsString(contactTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        contactEndToEndResponse = response.getBody(ContactResponse.class);
    }

    @AfterMethod(onlyForGroups = "deleteContact")
    public void deleteContactAfter() {
        ApiRequest apiRequest = baseRequest().method(ApiMethod.DELETE).endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contactEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
