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

package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Token {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String access_token;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String instance_url;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token_type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String issued_at;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String signature;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(final String access_token) {
        this.access_token = access_token;
    }

    public String getInstance_url() {
        return instance_url;
    }

    public void setInstance_url(final String instance_url) {
        this.instance_url = instance_url;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(final String token_type) {
        this.token_type = token_type;
    }

    public String getIssued_at() {
        return issued_at;
    }

    public void setIssued_at(final String issued_at) {
        this.issued_at = issued_at;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }
}

