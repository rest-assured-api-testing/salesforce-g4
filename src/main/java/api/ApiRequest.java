/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package api;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiRequest<T> {
    private String baseUri;
    private String endpoint;
    private String body;
    private Enum<ApiMethod> method;
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Map<String, String> params;

    public ApiRequest() {
        headers = new ArrayList<>();
        queryParams = new HashMap<>();
        pathParams = new HashMap<>();
        params = new HashMap<>();
    }

    /*
     * Gets the base Uri.
     *
     * @return a String with the base Uri.
     */
    public String getBaseUri() {
        return baseUri;
    }

    /*
     * Sets the value for the base Uri.
     *
     * @param baseUri String with value for the base Uri.
     */
    public void setBaseUri(final String baseUri) {
        this.baseUri = baseUri;
    }

    /*
     * Gets the endpoint.
     *
     * @return a String with the resource's endpoint.
     */
    public String getEndpoint() {
        if (endpoint == null) {
            return "";
        }
        return endpoint;
    }

    /*
     * Sets the value for the endpoint.
     *
     * @param endpoint String with value for the base Uri.
     */
    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    /*
     * Gets the request's body.
     *
     * @return a String with the body request.
     */
    public String getBody() {
        if (body == null) {
            return "";
        }
        return body;
    }

    /*
     * Sets the value for the body request.
     *
     * @param body String with body for the request.
     */
    public void setBody(final String body) {
        this.body = body;
    }

    /*
     * Gets the request's method.
     *
     * @return a String with request method for the request.
     */
    public Enum<ApiMethod> getMethod() {
        return method;
    }

    /*
     * Sets the value request's type.
     *
     * @param method enum with type for the request.
     */
    public void setMethod(final Enum<ApiMethod> method) {
        this.method = method;
    }

    /**
     * Sets the values for header request.
     *
     * @param header String with the header's name.
     * @param value  String with the headers' value.
     */
    public void addHeaders(final String header, final String value) {
        headers.add(new Header(header, value));
    }

    /*
     * Gets the headers' request.
     *
     * @return a Object List of headers.
     */
    public Headers getHeaders() {
        return new Headers(headers);
    }

    /**
     * Sets the values for header request.
     *
     * @param param String with the header's name.
     * @param value  String with the headers' value.
     */
    public void addQueryParams(final String param, final String value) {
        queryParams.put(param, value);
    }

    /*
     * Gets the request query params.
     *
     * @return a Map with List of query params.
     */
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Sets the values for path params.
     *
     * @param param String with the path params name.
     * @param value  String with the path params value.
     */
    public void addPathParams(final String param, final String value) {
        pathParams.put(param, value);
    }

    /*
     * Gets the request path params.
     *
     * @return a Map with List of path params.
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }

    /**
     * Sets the values for params.
     *
     * @param param String with the params name.
     * @param value  String with the params value.
     */
    public void addParams(final String param, final String value) {
        params.put(param, value);
    }

    /*
     * Gets the request params.
     *
     * @return a Map with List of params.
     */
    public Map<String, String> getParams() {
        return params;
    }
}
