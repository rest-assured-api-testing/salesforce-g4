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
import salesforce.generalsetting.EndPoint;
import salesforce.generalsetting.Param;
import salesforce.generalsetting.Header;
import utilities.ObjectInformation;
import salesforce.entities.Token;
import salesforce.entities.group.Group;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class GroupHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private Group groupCreate;
    private ObjectInformation objectInformation = new ObjectInformation();

    public GroupHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@GetGroup or @PostGroup or @DeleteGroup or @PatchGroup", order = 1)
    public void generateToken() {
        log.info("Generate Token");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .params(Param.USERNAME.getKey(), Param.USERNAME.getValue())
                .params(Param.PASSWORD.getKey(), Param.PASSWORD.getValue())
                .params(Param.CLIENT_ID.getKey(), Param.CLIENT_ID.getValue())
                .params(Param.CLIENT_SECRET.getKey(), Param.CLIENT_SECRET.getValue())
                .params(Param.GRANT_TYPE.getKey(), Param.GRANT_TYPE.getValue())
                .headers(Header.ACCEPT.getValue(), Header.APPLICATION_JSON.getValue())
                .headers(Header.CONTENT_TYPE.getValue(), Header.X_WWW_FORM_URLENCODED.getValue())
                .baseUri(EndPoint.TOKEN.getEndPoint())
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.executeParam(apiRequest);
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetGroup or @DeleteGroup or @PatchGroup", order = 2)
    public void createProduct() throws JsonProcessingException {
        log.info("Create Group");
        Group group = new Group();
        group.setName("group-test-created");
        group.setVisibility("PublicAccess");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.GROUP.getEndPoint())
                .body(new ObjectMapper().writeValueAsString(group))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        groupCreate = apiResponse.getBody(Group.class);
        objectInformation.setId(groupCreate.getId());
    }

    @After(value = "@GetGroup or @PatchGroup or @DeleteGroup")
    public void cleanRepository() {
        log.info("Delete Product");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.GROUP.getEndPointInteract())
                .pathParams(EndPoint.GROUP.toSetId(), groupCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostGroup")
    public void cleanRepositoryPost() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.GROUP.getEndPointInteract())
                .pathParams(EndPoint.GROUP.toSetId(), objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
