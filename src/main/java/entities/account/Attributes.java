/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */

package entities.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("type")
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("url")
    private String url;

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
