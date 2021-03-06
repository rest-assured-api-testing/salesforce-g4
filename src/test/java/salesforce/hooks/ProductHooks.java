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
import salesforce.entities.product.Product;
import salesforce.entities.product.ProductCreate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class ProductHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private ProductCreate productCreate;
    private ObjectInformation objectInformation = new ObjectInformation();

    public ProductHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@GetProduct or @PostProduct or @DeleteProduct or @PatchProduct", order = 1)
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

    @Before(value = "@GetProduct or @DeleteProduct or @PatchProduct", order = 2)
    public void createProduct() throws JsonProcessingException {
        log.info("Create Product");
        Product product = new Product();
        product.setName("Product-test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.PRODUCT.getEndPoint())
                .body(new ObjectMapper().writeValueAsString(product))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        productCreate = apiResponse.getBody(ProductCreate.class);
        objectInformation.setId(productCreate.getId());
    }

    @After(value = "@GetProduct or @PatchProduct or @DeleteProduct")
    public void cleanRepository() {
        log.info("Delete Product");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .endpoint(EndPoint.PRODUCT.getEndPointInteract())
                .pathParams(EndPoint.PRODUCT.toSetId(), productCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@PostProduct")
    public void cleanRepositoryPost() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(EndPoint.URL_BASE.getEndPoint())
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(EndPoint.PRODUCT.getEndPointInteract())
                .pathParams(EndPoint.PRODUCT.toSetId(), objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
