/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package api;

import generalsetting.ParameterEndPoints;
import generalsetting.ParameterUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ApiManager {
    private static int status;


    /**
     * Executes the Api request and assignment to response.
     *
     * @param apiRequest contains all the parameters for the execution to request.
     * @return a new instance to response.
     */
    public static ApiResponse execute(final ApiRequest apiRequest) {
        Response response = buildRequest(apiRequest)
                .request(apiRequest.getMethod().name(),
                        apiRequest.getEndpoint());
        return new ApiResponse(response);
    }

    /**
     * Sets all the params from Api request .
     *
     * @param apiRequest contains all the parameters for the request.
     * @return a request with oll the params to use.
     */
    private static RequestSpecification buildRequest(final ApiRequest apiRequest) {
        return given().headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .body(apiRequest.getBody())
                .contentType(ContentType.JSON)
                .log().all();
    }

    /**
     * Executes the Api request and assignment to response using param.
     *
     * @param apiRequest contains all the parameters for the execution to request.
     * @return a new instance to response.
     */
    public static ApiResponse executeParam(final ApiRequest apiRequest) {
        Response response = given().headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .params(apiRequest.getParams())
                .log().all()
                .request(apiRequest.getMethod().name(),
                        apiRequest.getEndpoint());
        return new ApiResponse(response);
    }

    /**
     * Executes the request to get a token.
     *
     * @return the token for our account.
     */
    public static ApiResponse executeToken() {
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
