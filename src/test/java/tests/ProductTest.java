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
package tests;

import api.ApiResponse;
import api.ApiManager;
import api.IBuilderApiRequest;
import api.ApiRequestBuilder;
import api.ApiRequest;
import api.ApiMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.product.Product;
import entities.Token;
import entities.product.ProductCreate;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import generalsetting.ParameterEndPoints;
public class ProductTest {
    private String tokenUser;
    private ProductCreate productCreate;

    public IBuilderApiRequest baseRequestProduct() {
        return new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser);
    }

    @BeforeClass
    public void getToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser=apiResponse.getBody(Token.class).getAccess_token();
    }

    @BeforeMethod(onlyForGroups= "getProduct")
    public void createProduct() throws JsonProcessingException {
        Product product=new Product();
        product.setName("Product-test");
        ApiRequest apiRequest =  baseRequestProduct()
                .endpoint(ParameterEndPoints.PRODUCT)
                .body(new ObjectMapper().writeValueAsString(product))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        productCreate=apiResponse.getBody(ProductCreate.class);
    }


    @AfterMethod(onlyForGroups= "getProduct")
    public void cleanRepository() {
        ApiRequest apiRequest =  baseRequestProduct()
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Test(groups = "getProduct")
    public void verifyProductSchema_Successful_200() {
        ApiRequest apiRequest =  baseRequestProduct()
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.GET).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        apiResponse.validateBodySchema("schemas/product.json");
    }
}
