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

public class productHooks {
    private Logger log = Logger.getLogger(getClass());
    private String tokenUser;
    private ProductCreate productCreate;
    private ObjectInformation objectInformation =new ObjectInformation();

    public productHooks(ObjectInformation objectInformation) {
        log.info("ScenariosHooks constructor");
        this.objectInformation=objectInformation;
    }

    @Before(value = "@GetProduct or @PostProduct or @DeleteProduct or @PathProduct", order = 1)
    public void generateToken() {
        log.info("Generate Token");
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser = apiResponse.getBody(Token.class).getAccess_token();
        objectInformation.setToken(tokenUser);
    }

    @Before(value = "@GetProduct or @DeleteProduct or @PathProduct", order = 2)
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
        objectInformation.setId(productCreate.getId());
    }

    @After(value = "@GetProduct or @PathProduct")
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

    @After(value = "@PostProduct")
    public void cleanRepositoryPost() {
        log.info("Delete Product Post");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + tokenUser)
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .pathParams(ParameterEndPoints.PRODUCT_ID, objectInformation.getIdDelete())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }
}
