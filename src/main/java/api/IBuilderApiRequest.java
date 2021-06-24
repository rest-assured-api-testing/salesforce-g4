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
    ApiRequest build();

    ApiRequestBuilder body(String body);

    ApiRequestBuilder method(Enum<ApiMethod> method);

    ApiRequestBuilder headers(String header, String value);

    ApiRequestBuilder pathParams(String param, String value);

    ApiRequestBuilder endpoint(String endpoint);
}
