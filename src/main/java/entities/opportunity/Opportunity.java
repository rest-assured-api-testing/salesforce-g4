/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */

package entities.opportunity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Opportunity {
    private Attributes attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("AccountId")
    private Object accountId;
    @JsonProperty("IsPrivate")
    private Boolean isPrivate;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private Object description;
    @JsonProperty("StageName")
    private String stageName;
    @JsonProperty("Amount")
    private Object amount;
    @JsonProperty("Probability")
    private double probability;
    @JsonProperty("ExpectedRevenue")
    private Object expectedRevenue;
    @JsonProperty("TotalOpportunityQuantity")
    private Object totalOpportunityQuantity;
    @JsonProperty("CloseDate")
    private String closeDate;
    @JsonProperty("Type")
    private Object type;
    @JsonProperty("NextStep")
    private Object nextStep;
    @JsonProperty("LeadSource")
    private Object leadSource;
    @JsonProperty("IsClosed")
    private Boolean isClosed;
    @JsonProperty("IsWon")
    private Boolean isWon;
    @JsonProperty("ForecastCategory")
    private String forecastCategory;
    @JsonProperty("ForecastCategoryName")
    private String forecastCategoryName;
    @JsonProperty("CampaignId")
    private Object campaignId;
    @JsonProperty("HasOpportunityLineItem")
    private Boolean hasOpportunityLineItem;
    @JsonProperty("Pricebook2Id")
    private Object pricebook2Id;
    @JsonProperty("OwnerId")
    private String ownerId;
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
    @JsonProperty("LastActivityDate")
    private Object lastActivityDate;
    @JsonProperty("FiscalQuarter")
    private int fiscalQuarter;
    @JsonProperty("FiscalYear")
    private int fiscalYear;
    @JsonProperty("Fiscal")
    private String fiscal;
    @JsonProperty("ContactId")
    private Object contactId;
    @JsonProperty("LastViewedDate")
    private Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    private Date lastReferencedDate;
    @JsonProperty("HasOpenActivity")
    private Boolean hasOpenActivity;
    @JsonProperty("HasOverdueTask")
    private Boolean hasOverdueTask;
    @JsonProperty("LastAmountChangedHistoryId")
    private Object lastAmountChangedHistoryId;
    @JsonProperty("LastCloseDateChangedHistoryId")
    private Object lastCloseDateChangedHistoryId;
    @JsonProperty("DeliveryInstallationStatus__c")
    private Object deliveryInstallationStatus__c;
    @JsonProperty("TrackingNumber__c")
    private Object trackingNumber__c;
    @JsonProperty("OrderNumber__c")
    private Object orderNumber__c;
    @JsonProperty("CurrentGenerators__c")
    private Object currentGenerators__c;
    @JsonProperty("MainCompetitors__c")
    private Object mainCompetitors__c;

    public Opportunity() {
    }

    public Opportunity(final String name, final String closeDate, final String stageName) {
        this.name = name;
        this.stageName = stageName;
        this.closeDate = closeDate;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(final Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted) {
        isDeleted = deleted;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(final Object accountId) {
        this.accountId = accountId;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(final Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(final Object description) {
        this.description = description;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(final String stageName) {
        this.stageName = stageName;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(final Object amount) {
        this.amount = amount;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public Object getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(final Object expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Object getTotalOpportunityQuantity() {
        return totalOpportunityQuantity;
    }

    public void setTotalOpportunityQuantity(final Object totalOpportunityQuantity) {
        this.totalOpportunityQuantity = totalOpportunityQuantity;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(final String closeDate) {
        this.closeDate = closeDate;
    }

    public Object getType() {
        return type;
    }

    public void setType(final Object type) {
        this.type = type;
    }

    public Object getNextStep() {
        return nextStep;
    }

    public void setNextStep(final Object nextStep) {
        this.nextStep = nextStep;
    }

    public Object getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(final Object leadSource) {
        this.leadSource = leadSource;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(final Boolean closed) {
        isClosed = closed;
    }

    public Boolean getWon() {
        return isWon;
    }

    public void setWon(final Boolean won) {
        isWon = won;
    }

    public String getForecastCategory() {
        return forecastCategory;
    }

    public void setForecastCategory(final String forecastCategory) {
        this.forecastCategory = forecastCategory;
    }

    public String getForecastCategoryName() {
        return forecastCategoryName;
    }

    public void setForecastCategoryName(final String forecastCategoryName) {
        this.forecastCategoryName = forecastCategoryName;
    }

    public Object getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(final Object campaignId) {
        this.campaignId = campaignId;
    }

    public Boolean getHasOpportunityLineItem() {
        return hasOpportunityLineItem;
    }

    public void setHasOpportunityLineItem(final Boolean hasOpportunityLineItem) {
        this.hasOpportunityLineItem = hasOpportunityLineItem;
    }

    public Object getPricebook2Id() {
        return pricebook2Id;
    }

    public void setPricebook2Id(final Object pricebook2Id) {
        this.pricebook2Id = pricebook2Id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
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

    public Object getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(final Object lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public int getFiscalQuarter() {
        return fiscalQuarter;
    }

    public void setFiscalQuarter(int fiscalQuarter) {
        this.fiscalQuarter = fiscalQuarter;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getFiscal() {
        return fiscal;
    }

    public void setFiscal(final String fiscal) {
        this.fiscal = fiscal;
    }

    public Object getContactId() {
        return contactId;
    }

    public void setContactId(final Object contactId) {
        this.contactId = contactId;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(final Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(final Date lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public Boolean getHasOpenActivity() {
        return hasOpenActivity;
    }

    public void setHasOpenActivity(final Boolean hasOpenActivity) {
        this.hasOpenActivity = hasOpenActivity;
    }

    public Boolean getHasOverdueTask() {
        return hasOverdueTask;
    }

    public void setHasOverdueTask(final Boolean hasOverdueTask) {
        this.hasOverdueTask = hasOverdueTask;
    }

    public Object getLastAmountChangedHistoryId() {
        return lastAmountChangedHistoryId;
    }

    public void setLastAmountChangedHistoryId(final Object lastAmountChangedHistoryId) {
        this.lastAmountChangedHistoryId = lastAmountChangedHistoryId;
    }

    public Object getLastCloseDateChangedHistoryId() {
        return lastCloseDateChangedHistoryId;
    }

    public void setLastCloseDateChangedHistoryId(final Object lastCloseDateChangedHistoryId) {
        this.lastCloseDateChangedHistoryId = lastCloseDateChangedHistoryId;
    }

    public Object getDeliveryInstallationStatus__c() {
        return deliveryInstallationStatus__c;
    }

    public void setDeliveryInstallationStatus__c(final Object deliveryInstallationStatus__c) {
        this.deliveryInstallationStatus__c = deliveryInstallationStatus__c;
    }

    public Object getTrackingNumber__c() {
        return trackingNumber__c;
    }

    public void setTrackingNumber__c(final Object trackingNumber__c) {
        this.trackingNumber__c = trackingNumber__c;
    }

    public Object getOrderNumber__c() {
        return orderNumber__c;
    }

    public void setOrderNumber__c(final Object orderNumber__c) {
        this.orderNumber__c = orderNumber__c;
    }

    public Object getCurrentGenerators__c() {
        return currentGenerators__c;
    }

    public void setCurrentGenerators__c(final Object currentGenerators__c) {
        this.currentGenerators__c = currentGenerators__c;
    }

    public Object getMainCompetitors__c() {
        return mainCompetitors__c;
    }

    public void setMainCompetitors__c(final Object mainCompetitors__c) {
        this.mainCompetitors__c = mainCompetitors__c;
    }
}
