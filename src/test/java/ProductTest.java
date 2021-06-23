import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.project.Product;
import entities.Token;
import entities.project.ProductCreate;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import generalsetting.ParameterEndPoints;
public class ProductTest {
    private String tokenUser;
    private Product project=new Product();
    private ProductCreate productCreate;

    @BeforeClass
    public void getToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser=apiResponse.getBody(Token.class).getAccess_token();
    }
    @BeforeMethod(onlyForGroups= "getProduct")
    public void createProduct() throws JsonProcessingException {
        Product product=new Product();
        product.setName("Project-test");
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .endpoint(ParameterEndPoints.PRODUCT)
                .headers("Authorization","Bearer " + tokenUser)
                .body(new ObjectMapper().writeValueAsString(product))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        productCreate=apiResponse.getBody(ProductCreate.class);
    }


    @AfterMethod(onlyForGroups= "getProduct")
    public void cleanRepository() {
        Product product=new Product();
        product.setName("Project-test");
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .headers("Authorization","Bearer " + tokenUser)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Test(groups = "getProduct")
    public void verifyProductSchema_Successful_200() throws JsonProcessingException {
        ApiRequest apiRequest =  new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .endpoint(ParameterEndPoints.PRODUCT_TO_INTERACT)
                .headers("Authorization","Bearer " + tokenUser)
                .pathParams(ParameterEndPoints.PRODUCT_ID, productCreate.getId())
                .method(ApiMethod.GET).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        apiResponse.validateBodySchema("schemas/product.json");
    }
}
