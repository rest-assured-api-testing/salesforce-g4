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

package entities.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Individual {

    private Attribute attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("OwnerId")
    private String ownerId;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("Salutation")
    private String salutation;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("HasOptedOutTracking")
    private Boolean hasOptedOutTracking;
    @JsonProperty("HasOptedOutProfiling")
    private Boolean hasOptedOutProfiling;
    @JsonProperty("HasOptedOutProcessing")
    private Boolean hasOptedOutProcessing;
    @JsonProperty("HasOptedOutSolicit")
    private Boolean hasOptedOutSolicit;
    @JsonProperty("ShouldForget")
    private Boolean shouldForget;
    @JsonProperty("SendIndividualData")
    private Boolean sendIndividualData;
    @JsonProperty("CanStorePiiElsewhere")
    private Boolean canStorePiiElsewhere;
    @JsonProperty("HasOptedOutGeoTracking")
    private Boolean hasOptedOutGeoTracking;
    @JsonProperty("BirthDate")
    private String birthDate;
    @JsonProperty("DeathDate")
    private String deathDate;
    @JsonProperty("ConvictionsCount")
    private String convictionsCount;
    @JsonProperty("ChildrenCount")
    private String childrenCount;
    @JsonProperty("MilitaryService")
    private String militaryService;
    @JsonProperty("IsHomeOwner")
    private Boolean isHomeOwner;
    @JsonProperty("Occupation")
    private String occupation;
    @JsonProperty("Website")
    private String website;
    @JsonProperty("IndividualsAge")
    private String individualsAge;
    @JsonProperty("LastViewedDate")
    private Date lastViewedDate;
    @JsonProperty("MasterRecordId")
    private String masterRecordId;
    @JsonProperty("ConsumerCreditScore")
    private String consumerCreditScore;
    @JsonProperty("ConsumerCreditScoreProviderName")
    private String consumerCreditScoreProviderName;
    @JsonProperty("InfluencerRating")
    private String influencerRating;
    @JsonProperty("CreatedDate")
    private Date createdDate;
    @JsonProperty("CreatedById")
    private String createdById;
    @JsonProperty("LastModifiedDate")
    private Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    private String lastModifiedById;
    @JsonProperty("SystemModstamp")
    private Date systemModstamp;

    public Individual() {
    }

    public Individual(String lastName) {
        this.lastName = lastName;
    }

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(final Attribute attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted) {
        isDeleted = deleted;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean isHasOptedOutTracking() {
        return hasOptedOutTracking;
    }

    public void setHasOptedOutTracking(final Boolean hasOptedOutTracking) {
        this.hasOptedOutTracking = hasOptedOutTracking;
    }

    public Boolean isHasOptedOutProfiling() {
        return hasOptedOutProfiling;
    }

    public void setHasOptedOutProfiling(final Boolean hasOptedOutProfiling) {
        this.hasOptedOutProfiling = hasOptedOutProfiling;
    }

    public Boolean isHasOptedOutProcessing() {
        return hasOptedOutProcessing;
    }

    public void setHasOptedOutProcessing(final Boolean hasOptedOutProcessing) {
        this.hasOptedOutProcessing = hasOptedOutProcessing;
    }

    public Boolean isHasOptedOutSolicit() {
        return hasOptedOutSolicit;
    }

    public void setHasOptedOutSolicit(final Boolean hasOptedOutSolicit) {
        this.hasOptedOutSolicit = hasOptedOutSolicit;
    }

    public Boolean isShouldForget() {
        return shouldForget;
    }

    public void setShouldForget(final Boolean shouldForget) {
        this.shouldForget = shouldForget;
    }

    public Boolean isSendIndividualData() {
        return sendIndividualData;
    }

    public void setSendIndividualData(final Boolean sendIndividualData) {
        this.sendIndividualData = sendIndividualData;
    }

    public Boolean isCanStorePiiElsewhere() {
        return canStorePiiElsewhere;
    }

    public void setCanStorePiiElsewhere(final Boolean canStorePiiElsewhere) {
        this.canStorePiiElsewhere = canStorePiiElsewhere;
    }

    public Boolean isHasOptedOutGeoTracking() {
        return hasOptedOutGeoTracking;
    }

    public void setHasOptedOutGeoTracking(final Boolean hasOptedOutGeoTracking) {
        this.hasOptedOutGeoTracking = hasOptedOutGeoTracking;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(final String deathDate) {
        this.deathDate = deathDate;
    }

    public String getConvictionsCount() {
        return convictionsCount;
    }

    public void setConvictionsCount(final String convictionsCount) {
        this.convictionsCount = convictionsCount;
    }

    public String getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(final String childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(final String militaryService) {
        this.militaryService = militaryService;
    }

    public Boolean isHomeOwner() {
        return isHomeOwner;
    }

    public void setHomeOwner(final Boolean homeOwner) {
        isHomeOwner = homeOwner;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(final String occupation) {
        this.occupation = occupation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(final String website) {
        this.website = website;
    }

    public String getIndividualsAge() {
        return individualsAge;
    }

    public void setIndividualsAge(final String individualsAge) {
        this.individualsAge = individualsAge;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(final Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getMasterRecordId() {
        return masterRecordId;
    }

    public void setMasterRecordId(final String masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    public String getConsumerCreditScore() {
        return consumerCreditScore;
    }

    public void setConsumerCreditScore(final String consumerCreditScore) {
        this.consumerCreditScore = consumerCreditScore;
    }

    public String getConsumerCreditScoreProviderName() {
        return consumerCreditScoreProviderName;
    }

    public void setConsumerCreditScoreProviderName(final String consumerCreditScoreProviderName) {
        this.consumerCreditScoreProviderName = consumerCreditScoreProviderName;
    }

    public String getInfluencerRating() {
        return influencerRating;
    }

    public void setInfluencerRating(final String influencerRating) {
        this.influencerRating = influencerRating;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(final Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(final Date systemModstamp) {
        this.systemModstamp = systemModstamp;
    }
}
