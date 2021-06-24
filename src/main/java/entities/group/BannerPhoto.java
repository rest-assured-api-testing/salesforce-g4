/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BannerPhoto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object bannerPhotoVersionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bannerPhotoUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;

    public void setBannerPhotoVersionId(final Object bannerPhotoVersionId) {
        this.bannerPhotoVersionId = bannerPhotoVersionId;
    }

    public Object getBannerPhotoVersionId() {
        return bannerPhotoVersionId;
    }

    public void setBannerPhotoUrl(final String bannerPhotoUrl) {
        this.bannerPhotoUrl = bannerPhotoUrl;
    }

    public String getBannerPhotoUrl() {
        return bannerPhotoUrl;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
