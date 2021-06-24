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

public interface IBuilderApiRequest {

    /**
     * Set endpoint to request
     *
     * @param endpoint is the path to endpoint
     */
    ApiRequestBuilder endpoint(String endpoint);

    /**
     * Sets body to response
     *
     * @param body is body to request
     */
    ApiRequestBuilder body(String body);

    /**
     * Sets method to response
     *
     * @param method is method to response
     */
    ApiRequestBuilder method(Enum<ApiMethod> method);

    /**
     * Sets headers to request
     *
     * @param header is the key of header
     * @param value is a value of header
     */
    ApiRequestBuilder headers(final String header, final String value);

    /**
     * Sets params to request
     *
     * @param param is the key of param
     * @param value is a value of param
     */
    ApiRequestBuilder pathParams(final String param, final String value);

    /**
     * Finishes the build to object
     */
    ApiRequest build();
}
