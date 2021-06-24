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

public class ApiRequestBuilder implements IBuilderApiRequest {
    private ApiRequest apiRequest;

    public ApiRequestBuilder() {
        this.apiRequest = new ApiRequest();
    }

    /**
     * Set the base Uri to request
     *
     * @param baseUri is path to base Uri to request
     * @return ApiRequest in order to build request
     */
    public ApiRequestBuilder baseUri(String baseUri) {
        this.apiRequest.setBaseUri(baseUri);
        return this;
    }

    /**
     * Set endpoint to request
     *
     * @param endpoint is the path to endpoint
     * @return ApiRequest in order to build request
     */
    public ApiRequestBuilder endpoint(String endpoint) {
        this.apiRequest.setEndpoint(endpoint);
        return this;
    }

    /**
     * Sets body to response
     *
     * @param body is body to request
     * @return ApiRequest in order to build request
     */
    public ApiRequestBuilder body(String body) {
        this.apiRequest.setBody(body);
        return this;
    }

    /**
     * Sets method to response
     *
     * @param method is method to response
     * @return ApiRequest in order to build request
     */
    public ApiRequestBuilder method(Enum<ApiMethod> method) {
        this.apiRequest.setMethod(method);
        return this;
    }

    /**
     * Sets headers to request
     *
     * @param header is the key of header
     * @param value  is a value of header
     * @return ApiRequest in order to build request
     */
    public ApiRequestBuilder headers(final String header, final String value) {
        this.apiRequest.addHeaders(header, value);
        return this;
    }

    /**
     * Sets params to request
     *
     * @param param is the key of param
     * @param value is a value of param
     * @return ApiRequest in order to build request
     */
    public ApiRequestBuilder pathParams(final String param, final String value) {
        this.apiRequest.addPathParams(param, value);
        return this;
    }

    /**
     * Finishes the build to object
     *
     * @return ApiRequest in order to build request
     */
    public ApiRequest build() {
        return apiRequest;
    }
}
