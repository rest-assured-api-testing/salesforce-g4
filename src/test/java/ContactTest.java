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

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import generalsetting.ParameterEndPoints;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTestContact{
    @Test
    public void get_all_contact_successful_200() {
        ApiRequest apiRequest = baseRequest().method(ApiMethod.GET).endpoint(ParameterEndPoints.CONTACT).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"createContact","deleteContact"})
    public void get_contact_successful_200(){
        ApiRequest apiRequest = baseRequest().method(ApiMethod.GET).endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contactEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(),HttpStatus.SC_OK);
    }

    @Test(groups = {"deleteContact"})
    public void create_contact_successful_200() throws JsonProcessingException {
        Contact contactTemp = new Contact("Contact41");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.POST).endpoint(ParameterEndPoints.CONTACT)
                .body(new ObjectMapper().writeValueAsString(contactTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED);
        contactEndToEndResponse = response.getBody(ContactResponse.class);
    }

    @Test(groups = {"createContact","deleteContact"})
    public void update_contact_successful_201() throws JsonProcessingException {
        Contact contactTemp = new Contact("Account new Update");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.PATCH).endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contactEndToEndResponse.getId())
                .body(new ObjectMapper().writeValueAsString(contactTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = {"createContact"})
    public void delete_contact_successful_204() {
        ApiRequest apiRequest = baseRequest().method(ApiMethod.DELETE).endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contactEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
