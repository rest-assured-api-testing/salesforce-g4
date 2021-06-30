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
import entities.account.Account;
import entities.account.AccountResponse;
import entities.campaign.Campaign;
import entities.campaign.CampaignCreate;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import entities.group.Group;
import generalsetting.ParameterUser;
import utilities.ObjectInformation;
import entities.Token;
import entities.product.Product;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class ProductHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private ProductCreate productCreate;
    private Group groupCreate;
    private ObjectInformation objectInformation = new ObjectInformation();
    private CampaignCreate campaignCreate;
    private AccountResponse accountResponse;
    private ContactResponse contactResponse;

    public ProductHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation = objectInformation;
    }

    public ApiRequestBuilder baseRequest() {
        return new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers(ParameterEndPoints.AUTHORIZATION, ParameterEndPoints.BEARER + tokenUser);
    }

    @Before(order = 1)
    public void generateToken() {
        log.info("Generate Token");
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

    @Before(value = "@GetProduct or @DeleteProduct or @PatchProduct", order = 2)
    public void createProduct() throws JsonProcessingException {
        log.info("Create Product");
        Product product = new Product();
        product.setName("Product-test");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.PRODUCT)
                .body(new ObjectMapper().writeValueAsString(product))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        productCreate = apiResponse.getBody(ProductCreate.class);
        objectInformation.setId(productCreate.getId());
    }

    @After(value = "@GetProduct or @PatchProduct or @DeleteProduct")
    public void cleanRepository() {
        log.info("Delete Product");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostProduct")
    public void cleanRepositoryPost() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Before(value = "@GetGroup or @DeleteGroup or @PatchGroup", order = 2)
    public void createGroup() throws JsonProcessingException {
        log.info("Create Group");
        Group group=new Group();
        group.setName("group-test-created");
        group.setVisibility("PublicAccess");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.GROUP)
                .body(new ObjectMapper().writeValueAsString(group))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        groupCreate = apiResponse.getBody(Group.class);
        objectInformation.setId(groupCreate.getId());
    }

    @After(value = "@GetGroup or @PatchGroup or @DeleteGroup")
    public void cleanRepositoryGroup() {
        log.info("Delete Product");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.GROUP_TO_INTERACT)
                .pathParams(ParameterEndPoints.GROUP_ID, groupCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostGroup")
    public void cleanRepositoryPostGroup() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.GROUP_TO_INTERACT)
                .pathParams(ParameterEndPoints.GROUP_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Before(value = "@GetCampaign or @DeleteCampaign or @PatchCampaign", order = 2)
    public void createCampaign() throws JsonProcessingException {
        log.info("Create Campaign");
        Campaign campaign = new Campaign();
        campaign.setName("Campaign-test");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.CAMPAIGN)
                .body(new ObjectMapper().writeValueAsString(campaign))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        campaignCreate = apiResponse.getBody(CampaignCreate.class);
        objectInformation.setId(campaignCreate.getId());
    }

    @After(value = "@GetCampaign or @PatchCampaign or @DeleteCampaign")
    public void cleanRepositoryCampaign() {
        log.info("Delete Campaign");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.CAMPAIGN_TO_INTERACT)
                .pathParams(ParameterEndPoints.CAMPAIGN_ID, campaignCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostCampaign")
    public void cleanRepositoryPostCampaign() {
        log.info("Delete Campaign Post");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.CAMPAIGN_TO_INTERACT)
                .pathParams(ParameterEndPoints.CAMPAIGN_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Before(value = "@GetAccount or @DeleteAccount or @PatchAccount", order = 2)
    public void createAccountHooks() throws JsonProcessingException {
        log.info("Create Account hooks");
        Account account = new Account("account test");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.ACCOUNT)
                .body(new ObjectMapper().writeValueAsString(account))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        accountResponse = apiResponse.getBody(AccountResponse.class);
        objectInformation.setId(accountResponse.getId());
    }

    @After(value = "@GetAccount or @PatchAccount")
    public void deleteAccountHooks() {
        log.info("Delete Account hooks");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.ACCOUNT_TO_INTERACT)
                .pathParams(ParameterEndPoints.ACCOUNT_ID, accountResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostAccount")
    public void cleanRepositoryPostAccount() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.ACCOUNT_TO_INTERACT)
                .pathParams(ParameterEndPoints.ACCOUNT_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Before(value = "@GetContact or @DeleteContact or @PatchContact", order = 2)
    public void createContactHooks() throws JsonProcessingException {
        log.info("Create Contact");
        Contact contact = new Contact("contact test");
        ApiRequest apiRequest = baseRequest()
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
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, contactResponse.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostContact")
    public void cleanRepositoryPostContact() {
        log.info("Delete Contact Post");
        ApiRequest apiRequest = baseRequest()
                .endpoint(ParameterEndPoints.CONTACT_TO_INTERACT)
                .pathParams(ParameterEndPoints.CONTACT_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}