import api.*;
import entities.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenTest {
    Token token;

    @Test
    public void statusToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        Assert.assertEquals(apiResponse.getStatusCode(), 200);
    }

    @Test
    public void getToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
        Assert.assertEquals(apiResponse.getStatusCode(), 200);
    }

    @Test
    public void verifyTokenSchema_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        token=apiResponse.getBody(Token.class);
        apiResponse.validateBodySchema("schemas/token.json");
    }


}

