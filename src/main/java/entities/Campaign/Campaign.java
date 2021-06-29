package entities.Campaign;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Campaign {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object description;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isActive;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double amountAllOpportunities;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double expectedResponse;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastReferencedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object campaignMemberRecordTypeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int numberOfLeads;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int numberOfOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object startDate;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double numberSent;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int numberOfResponses;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object expectedRevenue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ownerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdById;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double amountWonOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object budgetedCost;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object parentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isDeleted;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int numberOfContacts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastViewedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object endDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object actualCost;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String systemModstamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int numberOfWonOpportunities;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object lastActivityDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Attributes attributes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedById;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int numberOfConvertedLeads;

    public void setLastModifiedDate(final String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setDescription(final Object description) {
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }

    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setAmountAllOpportunities(final double amountAllOpportunities) {
        this.amountAllOpportunities = amountAllOpportunities;
    }

    public double getAmountAllOpportunities() {
        return amountAllOpportunities;
    }

    public void setExpectedResponse(final double expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public double getExpectedResponse() {
        return expectedResponse;
    }

    public void setLastReferencedDate(final String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setCampaignMemberRecordTypeId(final Object campaignMemberRecordTypeId) {
        this.campaignMemberRecordTypeId = campaignMemberRecordTypeId;
    }

    public Object getCampaignMemberRecordTypeId() {
        return campaignMemberRecordTypeId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfLeads(final int numberOfLeads) {
        this.numberOfLeads = numberOfLeads;
    }

    public int getNumberOfLeads() {
        return numberOfLeads;
    }

    public void setNumberOfOpportunities(final int numberOfOpportunities) {
        this.numberOfOpportunities = numberOfOpportunities;
    }

    public int getNumberOfOpportunities() {
        return numberOfOpportunities;
    }

    public void setStartDate(final Object startDate) {
        this.startDate = startDate;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setNumberSent(final double numberSent) {
        this.numberSent = numberSent;
    }

    public double getNumberSent() {
        return numberSent;
    }

    public void setNumberOfResponses(final int numberOfResponses) {
        this.numberOfResponses = numberOfResponses;
    }

    public int getNumberOfResponses() {
        return numberOfResponses;
    }

    public void setExpectedRevenue(final Object expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Object getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setAmountWonOpportunities(final double amountWonOpportunities) {
        this.amountWonOpportunities = amountWonOpportunities;
    }

    public double getAmountWonOpportunities() {
        return amountWonOpportunities;
    }

    public void setBudgetedCost(final Object budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public Object getBudgetedCost() {
        return budgetedCost;
    }

    public void setParentId(final Object parentId) {
        this.parentId = parentId;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setIsDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setNumberOfContacts(final int numberOfContacts) {
        this.numberOfContacts = numberOfContacts;
    }

    public int getNumberOfContacts() {
        return numberOfContacts;
    }

    public void setLastViewedDate(final String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setEndDate(final Object endDate) {
        this.endDate = endDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setActualCost(final Object actualCost) {
        this.actualCost = actualCost;
    }

    public Object getActualCost() {
        return actualCost;
    }

    public void setSystemModstamp(final String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setNumberOfWonOpportunities(final int numberOfWonOpportunities) {
        this.numberOfWonOpportunities = numberOfWonOpportunities;
    }

    public int getNumberOfWonOpportunities() {
        return numberOfWonOpportunities;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setLastActivityDate(final Object lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Object getLastActivityDate() {
        return lastActivityDate;
    }

    public void setAttributes(final Attributes attributes) {
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setNumberOfConvertedLeads(final int numberOfConvertedLeads) {
        this.numberOfConvertedLeads = numberOfConvertedLeads;
    }

    public int getNumberOfConvertedLeads() {
        return numberOfConvertedLeads;
    }
}
