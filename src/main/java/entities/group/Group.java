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

public class Group {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean canHaveChatterGuests;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object pendingRequests;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isArchived;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isBroadcast;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int fileCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String myRole;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MySubscription mySubscription;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BannerPhoto bannerPhoto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastFeedElementPostDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Motif motif;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object announcement;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Owner owner;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailToChatterAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String visibility;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int memberCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Photo photo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isAutoArchiveDisabled;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object community;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object additionalLabel;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Information information;

    public void setCanHaveChatterGuests(final boolean canHaveChatterGuests) {
        this.canHaveChatterGuests = canHaveChatterGuests;
    }

    public boolean isCanHaveChatterGuests() {
        return canHaveChatterGuests;
    }

    public void setPendingRequests(final Object pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public Object getPendingRequests() {
        return pendingRequests;
    }

    public void setIsArchived(final boolean isArchived) {
        this.isArchived = isArchived;
    }

    public boolean isIsArchived() {
        return isArchived;
    }

    public void setIsBroadcast(final boolean isBroadcast) {
        this.isBroadcast = isBroadcast;
    }

    public boolean isIsBroadcast() {
        return isBroadcast;
    }

    public void setDescription(final Object description) {
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFileCount(final int fileCount) {
        this.fileCount = fileCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setMyRole(final String myRole) {
        this.myRole = myRole;
    }

    public String getMyRole() {
        return myRole;
    }

    public void setMySubscription(final MySubscription mySubscription) {
        this.mySubscription = mySubscription;
    }

    public MySubscription getMySubscription() {
        return mySubscription;
    }

    public void setBannerPhoto(final BannerPhoto bannerPhoto) {
        this.bannerPhoto = bannerPhoto;
    }

    public BannerPhoto getBannerPhoto() {
        return bannerPhoto;
    }

    public void setLastFeedElementPostDate(final String lastFeedElementPostDate) {
        this.lastFeedElementPostDate = lastFeedElementPostDate;
    }

    public String getLastFeedElementPostDate() {
        return lastFeedElementPostDate;
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

    public void setAnnouncement(final Object announcement) {
        this.announcement = announcement;
    }

    public Object getAnnouncement() {
        return announcement;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setEmailToChatterAddress(final String emailToChatterAddress) {
        this.emailToChatterAddress = emailToChatterAddress;
    }

    public String getEmailToChatterAddress() {
        return emailToChatterAddress;
    }

    public void setVisibility(final String visibility) {
        this.visibility = visibility;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setMemberCount(final int memberCount) {
        this.memberCount = memberCount;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setPhoto(final Photo photo) {
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setIsAutoArchiveDisabled(final boolean isAutoArchiveDisabled) {
        this.isAutoArchiveDisabled = isAutoArchiveDisabled;
    }

    public boolean isIsAutoArchiveDisabled() {
        return isAutoArchiveDisabled;
    }

    public void setCommunity(final Object community) {
        this.community = community;
    }

    public Object getCommunity() {
        return community;
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

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInformation(final Information information) {
        this.information = information;
    }

    public Information getInformation() {
        return information;
    }
}
