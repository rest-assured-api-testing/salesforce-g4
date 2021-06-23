/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package api;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiResponse {
    private Response response;

    /**
     * Sets the response.
     */
    public ApiResponse(Response response) {
        this.response = response;
    }

    /**
     * Gets the response.
     *
     * @return a Response.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Gets status code to response.
     *
     * @return a status code.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets the response in a object.
     *
     * @param cls
     * @param <T>
     * @return the response in a object.
     */
    public <T> T getBody(Class<T> cls) {
        return response.getBody().as(cls);
    }

//    public <T> List<T> getBody(Class <T> cls){
//        return response.getBody().as(cls);
//    }

    /**
     * Verifies schema with Path setting in String schema
     *
     * @param schema is path to schema type json
     */
    public void validateBodySchema(String schema) {
        response.then().log().body().assertThat().body(matchesJsonSchemaInClasspath(schema));
    }
}
