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

package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Owner {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isInThisCommunity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String displayName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String companyName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Photo photo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object reputation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isActive;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object additionalLabel;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OutOfOffice outOfOffice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String communityNickname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object mySubscription;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Motif motif;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userType;

    public void setIsInThisCommunity(final boolean isInThisCommunity) {
        this.isInThisCommunity = isInThisCommunity;
    }

    public boolean isIsInThisCommunity() {
        return isInThisCommunity;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setPhoto(final Photo photo) {
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setReputation(final Object reputation) {
        this.reputation = reputation;
    }

    public Object getReputation() {
        return reputation;
    }

    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setTitle(final Object title) {
        this.title = title;
    }

    public Object getTitle() {
        return title;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAdditionalLabel(final Object additionalLabel) {
        this.additionalLabel = additionalLabel;
    }

    public Object getAdditionalLabel() {
        return additionalLabel;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setOutOfOffice(final OutOfOffice outOfOffice) {
        this.outOfOffice = outOfOffice;
    }

    public OutOfOffice getOutOfOffice() {
        return outOfOffice;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCommunityNickname(final String communityNickname) {
        this.communityNickname = communityNickname;
    }

    public String getCommunityNickname() {
        return communityNickname;
    }

    public void setMySubscription(final Object mySubscription) {
        this.mySubscription = mySubscription;
    }

    public Object getMySubscription() {
        return mySubscription;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMotif(final Motif motif) {
        this.motif = motif;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
