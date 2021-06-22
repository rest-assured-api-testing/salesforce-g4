import api.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenTest {

    @Test
    public void getToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        Assert.assertEquals(apiResponse.getStatusCode(), 200);
    }
}

