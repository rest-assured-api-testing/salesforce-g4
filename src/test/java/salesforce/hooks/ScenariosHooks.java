package salesforce.hooks;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ObjectInformation;
import entities.Token;
import entities.product.Product;
import entities.product.ProductCreate;
import generalsetting.ParameterEndPoints;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class ScenariosHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private ProductCreate productCreate;
    private String idObject;
    private Token token;
    private ObjectInformation objectInformation =new ObjectInformation();

//    public ScenariosHooks(Token token, ProductCreate productCreate) {
//        log.info("ScenariosHooks constructor");
//        this.token = token;
//        this.productCreate=productCreate;
//    }

    public ScenariosHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation=objectInformation;
    }


    @Before(value = "@GetObject", order = 1)
    public void generateToken() {
        log.info("Generate Token");
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        token=apiResponse.getBody(Token.class);
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetObject", order = 2)
    public void createProduct() throws JsonProcessingException {
        log.info("Create Product");
        Product product = new Product();
        product.setName("Product-test");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.PRODUCT)
                .body(new ObjectMapper().writeValueAsString(product))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        productCreate = apiResponse.getBody(ProductCreate.class);
        idObject = productCreate.getId();
        objectInformation.setId(idObject);
    }

    @After(value = "@GetObject")
    public void cleanRepository() {
        log.info("Delete Product");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
