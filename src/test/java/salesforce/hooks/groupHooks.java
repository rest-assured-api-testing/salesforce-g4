/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package salesforce.hooks;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import api.ApiRequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ObjectInformation;
import entities.Token;
import entities.group.Group;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class groupHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private Group groupCreate;
    private ObjectInformation objectInformation = new ObjectInformation();

    public groupHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@GetGroup or @PostGroup or @DeleteGroup or @PatchGroup", order = 1)
    public void generateToken() {
        log.info("Generate Token");
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetGroup or @DeleteGroup or @PatchGroup", order = 2)
    public void createProduct() throws JsonProcessingException {
        log.info("Create Group");
        Group group=new Group();
        group.setName("group-test-created");
        group.setVisibility("PublicAccess");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.GROUP)
                .body(new ObjectMapper().writeValueAsString(group))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        groupCreate = apiResponse.getBody(Group.class);
        objectInformation.setId(groupCreate.getId());
    }

    @After(value = "@GetGroup or @PatchGroup")
    public void cleanRepository() {
        log.info("Delete Product");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.GROUP_TO_INTERACT)
                .pathParams(ParameterEndPoints.GROUP_ID, groupCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostGroup")
    public void cleanRepositoryPost() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.GROUP_TO_INTERACT)
                .pathParams(ParameterEndPoints.GROUP_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}