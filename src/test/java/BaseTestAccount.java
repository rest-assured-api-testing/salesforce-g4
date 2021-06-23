import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import entities.Token;
import entities.account.Account;
import entities.account.AccountResponse;
import generalsetting.ParameterEndPoints;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTestAccount {
    protected ApiRequest apiRequest = new ApiRequest();
    protected ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    protected AccountResponse accountEndToEndResponse= new AccountResponse();


    @BeforeClass
    public void setup(){
        ApiResponse response = ApiManager.executeToken();
        apiRequest = apiRequestBuilder
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + response.getBody(Token.class).getAccess_token())
                .build();
    }


    @BeforeMethod(onlyForGroups = "createAccount")
    public void createdAccountBefore() throws JsonProcessingException {
        Account accountTemp = new Account();
        accountTemp.setName("Account30");
        apiRequest = apiRequestBuilder.method(ApiMethod.POST).endpoint(ParameterEndPoints.ACCOUNT)
                .body(new ObjectMapper().writeValueAsString(accountTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        System.out.println(response.getResponse().then().log().all());
        accountEndToEndResponse = response.getBody(AccountResponse.class);
    }

    @AfterMethod(onlyForGroups = "deleteAccount")
    public void deleteAccountAfter() { ;
        apiRequest = apiRequestBuilder.method(ApiMethod.DELETE).endpoint("/Account/{accountId}")
                .pathParams("accountId", accountEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
