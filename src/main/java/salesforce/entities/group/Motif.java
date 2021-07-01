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

package salesforce.entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Motif {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mediumIconUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String color;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String largeIconUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String smallIconUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object svgIconUrl;

    public void setMediumIconUrl(final String mediumIconUrl) {
        this.mediumIconUrl = mediumIconUrl;
    }

    public String getMediumIconUrl() {
        return mediumIconUrl;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setLargeIconUrl(final String largeIconUrl) {
        this.largeIconUrl = largeIconUrl;
    }

    public String getLargeIconUrl() {
        return largeIconUrl;
    }

    public void setSmallIconUrl(final String smallIconUrl) {
        this.smallIconUrl = smallIconUrl;
    }

    public String getSmallIconUrl() {
        return smallIconUrl;
    }

    public void setSvgIconUrl(final Object svgIconUrl) {
        this.svgIconUrl = svgIconUrl;
    }

    public Object getSvgIconUrl() {
        return svgIconUrl;
    }
}
