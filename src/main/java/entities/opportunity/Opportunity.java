package entities.opportunity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Opportunity {
    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("AccountId")
    public Object accountId;
    @JsonProperty("IsPrivate")
    public Boolean isPrivate;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Description")
    public Object description;
    @JsonProperty("StageName")
    public String stageName;
    @JsonProperty("Amount")
    public Object amount;
    @JsonProperty("Probability")
    public double probability;
    @JsonProperty("ExpectedRevenue")
    public Object expectedRevenue;
    @JsonProperty("TotalOpportunityQuantity")
    public Object totalOpportunityQuantity;
    @JsonProperty("CloseDate")
    public String closeDate;
    @JsonProperty("Type")
    public Object type;
    @JsonProperty("NextStep")
    public Object nextStep;
    @JsonProperty("LeadSource")
    public Object leadSource;
    @JsonProperty("IsClosed")
    public Boolean isClosed;
    @JsonProperty("IsWon")
    public Boolean isWon;
    @JsonProperty("ForecastCategory")
    public String forecastCategory;
    @JsonProperty("ForecastCategoryName")
    public String forecastCategoryName;
    @JsonProperty("CampaignId")
    public Object campaignId;
    @JsonProperty("HasOpportunityLineItem")
    public Boolean hasOpportunityLineItem;
    @JsonProperty("Pricebook2Id")
    public Object pricebook2Id;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("CreatedDate")
    public Date createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public Date systemModstamp;
    @JsonProperty("LastActivityDate")
    public Object lastActivityDate;
    @JsonProperty("FiscalQuarter")
    public int fiscalQuarter;
    @JsonProperty("FiscalYear")
    public int fiscalYear;
    @JsonProperty("Fiscal")
    public String fiscal;
    @JsonProperty("ContactId")
    public Object contactId;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("HasOpenActivity")
    public Boolean hasOpenActivity;
    @JsonProperty("HasOverdueTask")
    public Boolean hasOverdueTask;
    @JsonProperty("LastAmountChangedHistoryId")
    public Object lastAmountChangedHistoryId;
    @JsonProperty("LastCloseDateChangedHistoryId")
    public Object lastCloseDateChangedHistoryId;
    @JsonProperty("DeliveryInstallationStatus__c")
    public Object deliveryInstallationStatus__c;
    @JsonProperty("TrackingNumber__c")
    public Object trackingNumber__c;
    @JsonProperty("OrderNumber__c")
    public Object orderNumber__c;
    @JsonProperty("CurrentGenerators__c")
    public Object currentGenerators__c;
    @JsonProperty("MainCompetitors__c")
    public Object mainCompetitors__c;

    public Opportunity() {
    }

    public Opportunity(String name, String closeDate, String stageName) {
        this.name = name;
        this.stageName = stageName;
        this.closeDate = closeDate;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
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

    public void setExpectedRevenue(Object expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Object getTotalOpportunityQuantity() {
        return totalOpportunityQuantity;
    }

    public void setTotalOpportunityQuantity(Object totalOpportunityQuantity) {
        this.totalOpportunityQuantity = totalOpportunityQuantity;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getNextStep() {
        return nextStep;
    }

    public void setNextStep(Object nextStep) {
        this.nextStep = nextStep;
    }

    public Object getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(Object leadSource) {
        this.leadSource = leadSource;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public Boolean getWon() {
        return isWon;
    }

    public void setWon(Boolean won) {
        isWon = won;
    }

    public String getForecastCategory() {
        return forecastCategory;
    }

    public void setForecastCategory(String forecastCategory) {
        this.forecastCategory = forecastCategory;
    }

    public String getForecastCategoryName() {
        return forecastCategoryName;
    }

    public void setForecastCategoryName(String forecastCategoryName) {
        this.forecastCategoryName = forecastCategoryName;
    }

    public Object getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Object campaignId) {
        this.campaignId = campaignId;
    }

    public Boolean getHasOpportunityLineItem() {
        return hasOpportunityLineItem;
    }

    public void setHasOpportunityLineItem(Boolean hasOpportunityLineItem) {
        this.hasOpportunityLineItem = hasOpportunityLineItem;
    }

    public Object getPricebook2Id() {
        return pricebook2Id;
    }

    public void setPricebook2Id(Object pricebook2Id) {
        this.pricebook2Id = pricebook2Id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(Date systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public Object getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Object lastActivityDate) {
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

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    public Object getContactId() {
        return contactId;
    }

    public void setContactId(Object contactId) {
        this.contactId = contactId;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public Date getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(Date lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public Boolean getHasOpenActivity() {
        return hasOpenActivity;
    }

    public void setHasOpenActivity(Boolean hasOpenActivity) {
        this.hasOpenActivity = hasOpenActivity;
    }

    public Boolean getHasOverdueTask() {
        return hasOverdueTask;
    }

    public void setHasOverdueTask(Boolean hasOverdueTask) {
        this.hasOverdueTask = hasOverdueTask;
    }

    public Object getLastAmountChangedHistoryId() {
        return lastAmountChangedHistoryId;
    }

    public void setLastAmountChangedHistoryId(Object lastAmountChangedHistoryId) {
        this.lastAmountChangedHistoryId = lastAmountChangedHistoryId;
    }

    public Object getLastCloseDateChangedHistoryId() {
        return lastCloseDateChangedHistoryId;
    }

    public void setLastCloseDateChangedHistoryId(Object lastCloseDateChangedHistoryId) {
        this.lastCloseDateChangedHistoryId = lastCloseDateChangedHistoryId;
    }

    public Object getDeliveryInstallationStatus__c() {
        return deliveryInstallationStatus__c;
    }

    public void setDeliveryInstallationStatus__c(Object deliveryInstallationStatus__c) {
        this.deliveryInstallationStatus__c = deliveryInstallationStatus__c;
    }

    public Object getTrackingNumber__c() {
        return trackingNumber__c;
    }

    public void setTrackingNumber__c(Object trackingNumber__c) {
        this.trackingNumber__c = trackingNumber__c;
    }

    public Object getOrderNumber__c() {
        return orderNumber__c;
    }

    public void setOrderNumber__c(Object orderNumber__c) {
        this.orderNumber__c = orderNumber__c;
    }

    public Object getCurrentGenerators__c() {
        return currentGenerators__c;
    }

    public void setCurrentGenerators__c(Object currentGenerators__c) {
        this.currentGenerators__c = currentGenerators__c;
    }

    public Object getMainCompetitors__c() {
        return mainCompetitors__c;
    }

    public void setMainCompetitors__c(Object mainCompetitors__c) {
        this.mainCompetitors__c = mainCompetitors__c;
    }
}
