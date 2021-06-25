
package api;

import generalsetting.ParameterEndPoints;
import generalsetting.ParameterUser;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ApiManager {
    private static int status;

    public static ApiResponse execute(ApiRequest apiRequest) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        Response response = buildRequest(apiRequest)
                .request(apiRequest.getMethod().name(),
                        apiRequest.getEndpoint());
        return new ApiResponse(response);
    }

    private static RequestSpecification buildRequest(ApiRequest apiRequest) {
        return given().headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .body(apiRequest.getBody())
                .contentType(ContentType.JSON)
                .log().all();
    }

    public static ApiResponse executeToken() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        Response response = given().urlEncodingEnabled(true)
                .param(ParameterUser.USERNAME_KEY, ParameterUser.USERNAME_VALUE)
                .param(ParameterUser.PASSWORD_KEY, ParameterUser.PASSWORD_VALUE + ParameterUser.TOKEN_SECURITY)
                .param(ParameterUser.CLIENT_ID_KEY, ParameterUser.CLIENT_ID_VALUE)
                .param(ParameterUser.CLIENT_SECRET_KEY, ParameterUser.CLIENT_SECRET_VALUE)
                .param(ParameterUser.GRANT_TYPE_KEY, ParameterUser.GRANT_TYPE_VALUE)
                .header("Accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .when()
                .post(ParameterEndPoints.URL_TOKEN);
        return new ApiResponse(response);
    }
}
