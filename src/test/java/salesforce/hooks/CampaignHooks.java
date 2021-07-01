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
import salesforce.entities.campaign.CampaignCreate;
import salesforce.entities.Token;
import salesforce.entities.campaign.Campaign;
import salesforce.generalsetting.EndPoint;
import salesforce.generalsetting.Param;
import salesforce.generalsetting.Header;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import utilities.ObjectInformation;

public class CampaignHooks {

    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private CampaignCreate campaignCreate;
    private ObjectInformation objectInformation = new ObjectInformation();

    public CampaignHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@GetCampaign or @PostCampaign or @DeleteCampaign or @PatchCampaign", order = 1)
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

    @Before(value = "@GetCampaign or @DeleteCampaign or @PatchCampaign", order = 2)
    public void createProduct() throws JsonProcessingException {
        log.info("Create Campaign");
        Campaign campaign = new Campaign();
        campaign.setName("Campaign-test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.CAMPAIGN.getEndPoint())
                .body(new ObjectMapper().writeValueAsString(campaign))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        campaignCreate = apiResponse.getBody(CampaignCreate.class);
        objectInformation.setId(campaignCreate.getId());
    }

    @After(value = "@GetCampaign or @PatchCampaign or @DeleteCampaign")
    public void cleanRepository() {
        log.info("Delete Campaign");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.CAMPAIGN.getEndPointInteract())
                .pathParams(EndPoint.CAMPAIGN.toSetId(), campaignCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostCampaign")
    public void cleanRepositoryPost() {
        log.info("Delete Campaign Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.CAMPAIGN.getEndPointInteract())
                .pathParams(EndPoint.CAMPAIGN.toSetId(), objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}

