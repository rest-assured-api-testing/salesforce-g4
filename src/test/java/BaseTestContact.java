import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Token;
import entities.account.Account;
import entities.account.AccountResponse;
import entities.contact.Contact;
import entities.contact.ContactResponse;
import generalsetting.ParameterEndPoints;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestContact {

    protected ContactResponse contactEndToEndResponse= new ContactResponse();

    public IBuilderApiResponse baseRequest() {
        ApiResponse response = ApiManager.executeToken();
        return new ApiRequestBuilder()
                .baseUri(ParameterEndPoints.URL_BASE)
                .headers("Authorization", "Bearer " + response.getBody(Token.class).getAccess_token());
    }


    @BeforeMethod(onlyForGroups = "createContact")
    public void createdContactBefore() throws JsonProcessingException {
        Contact contactTemp = new Contact();
        contactTemp.setLastName("Contact30");
        ApiRequest apiRequest = baseRequest().method(ApiMethod.POST).endpoint(ParameterEndPoints.CONTACT)
                .body(new ObjectMapper().writeValueAsString(contactTemp)).build();
        ApiResponse response = ApiManager.execute(apiRequest);
        contactEndToEndResponse = response.getBody(ContactResponse.class);
    }

    @AfterMethod(onlyForGroups = "deleteContact")
    public void deleteContactAfter() { ;
        ApiRequest apiRequest = baseRequest().method(ApiMethod.DELETE).endpoint("/Contact/{contactId}")
                .pathParams("contactId", contactEndToEndResponse.getId()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
