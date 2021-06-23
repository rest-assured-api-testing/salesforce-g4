import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.group.Group;
import entities.project.Product;
import generalsetting.ParameterEndPoints;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupTest {
    private String tokenUser;
    private String idGroup;

    public IBuilderApiResponse baseRequestGroup() {
        return new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization","Bearer " + tokenUser);
    }

    @BeforeClass
    public void getToken_Successful_200(){
        ApiResponse apiResponse = ApiManager.executeToken();
        tokenUser=apiResponse.getBody(Token.class).getAccess_token();
    }

    @AfterMethod(onlyForGroups= "getGroup")
    public void deleteGroup()
    {
        ApiRequest apiRequest = baseRequestGroup()
                .endpoint(ParameterEndPoints.GROUP_TO_INTERACT)
                .pathParams(ParameterEndPoints.GROUP_ID,idGroup)
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @Test(groups = "getGroup")
    public void verifyGroupSchema_Successful_200() throws JsonProcessingException {
        Group group=new Group();
        group.setName("Group-test");
        group.setVisibility("PublicAccess");
        ApiRequest apiRequest =  baseRequestGroup()
                .endpoint(ParameterEndPoints.GROUP)
                .body(new ObjectMapper().writeValueAsString(group))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        idGroup=apiResponse.getBody(Group.class).getId();
        apiResponse.validateBodySchema("schemas/groupResponseCreate.json");
    }

}
