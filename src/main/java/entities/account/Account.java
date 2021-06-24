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

package entities.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingLatitude")
    private Object shippingLatitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("LastModifiedDate")
    private String lastModifiedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingCity")
    private Object billingCity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("JigsawCompanyId")
    private Object jigsawCompanyId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("SLA__c")
    private Object slac;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("NaicsCode")
    private Object naicsCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Name")
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Industry")
    private Object industry;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CreatedById")
    private String createdById;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("OperatingHoursId")
    private Object operatingHoursId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("TickerSymbol")
    private Object tickerSymbol;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingGeocodeAccuracy")
    private Object billingGeocodeAccuracy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("AccountSource")
    private Object accountSource;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingPostalCode")
    private Object billingPostalCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("DandbCompanyId")
    private Object dandbCompanyId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("PhotoUrl")
    private String photoUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("MasterRecordId")
    private Object masterRecordId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("IsDeleted")
    private boolean isDeleted;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("LastViewedDate")
    private String lastViewedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingGeocodeAccuracy")
    private Object shippingGeocodeAccuracy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("DunsNumber")
    private Object dunsNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Sic")
    private Object sic;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingStreet")
    private Object shippingStreet;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CleanStatus")
    private String cleanStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingPostalCode")
    private Object shippingPostalCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("YearStarted")
    private Object yearStarted;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CreatedDate")
    private String createdDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CustomerPriority__c")
    private Object customerPriorityC;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingState")
    private Object shippingState;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Id")
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SicDesc")
    private Object sicDesc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingState")
    private Object billingState;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("AnnualRevenue")
    private Object annualRevenue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Jigsaw")
    private Object jigsaw;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Active__c")
    private Object activeC;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Site")
    private Object site;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Ownership")
    private Object ownership;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Description")
    private Object description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Rating")
    private Object rating;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Website")
    private Object website;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("LastReferencedDate")
    private String lastReferencedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingLatitude")
    private Object billingLatitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("NumberOfEmployees")
    private Object numberOfEmployees;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingAddress")
    private Object billingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("OwnerId")
    private String ownerId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("SLASerialNumber__c")
    private Object slaserialNumberC;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingLongitude")
    private Object billingLongitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Tradestyle")
    private Object tradestyle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Phone")
    private Object phone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("NumberofLocations__c")
    private Object numberofLocationsC;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("UpsellOpportunity__c")
    private Object upsellOpportunityC;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingCountry")
    private Object shippingCountry;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingCity")
    private Object shippingCity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ParentId")
    private Object parentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("NaicsDesc")
    private Object naicsDesc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("AccountNumber")
    private Object accountNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SystemModstamp")
    private String systemModstamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Type")
    private Object type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingCountry")
    private Object billingCountry;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SLAExpirationDate__c")
    private Object slaexpirationDateC;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("BillingStreet")
    private Object billingStreet;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingAddress")
    private Object shippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("LastActivityDate")
    private Object lastActivityDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Fax")
    private Object fax;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("LastModifiedById")
    private String lastModifiedById;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ShippingLongitude")
    private Object shippingLongitude;

    public Account() {
    }

    public Account(final String name) {
        this.name = name;
    }

    public void setShippingLatitude(final Object shippingLatitude) {
        this.shippingLatitude = shippingLatitude;
    }

    public Object getShippingLatitude() {
        return shippingLatitude;
    }

    public void setLastModifiedDate(final String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setBillingCity(final Object billingCity) {
        this.billingCity = billingCity;
    }

    public Object getBillingCity() {
        return billingCity;
    }

    public void setJigsawCompanyId(final Object jigsawCompanyId) {
        this.jigsawCompanyId = jigsawCompanyId;
    }

    public Object getJigsawCompanyId() {
        return jigsawCompanyId;
    }

    public void setSLAC(final Object sLAC) {
        this.slac = sLAC;
    }

    public Object getSLAC() {
        return slac;
    }

    public void setNaicsCode(final Object naicsCode) {
        this.naicsCode = naicsCode;
    }

    public Object getNaicsCode() {
        return naicsCode;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIndustry(final Object industry) {
        this.industry = industry;
    }

    public Object getIndustry() {
        return industry;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setOperatingHoursId(final Object operatingHoursId) {
        this.operatingHoursId = operatingHoursId;
    }

    public Object getOperatingHoursId() {
        return operatingHoursId;
    }

    public void setTickerSymbol(final Object tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public Object getTickerSymbol() {
        return tickerSymbol;
    }

    public void setBillingGeocodeAccuracy(final Object billingGeocodeAccuracy) {
        this.billingGeocodeAccuracy = billingGeocodeAccuracy;
    }

    public Object getBillingGeocodeAccuracy() {
        return billingGeocodeAccuracy;
    }

    public void setAccountSource(final Object accountSource) {
        this.accountSource = accountSource;
    }

    public Object getAccountSource() {
        return accountSource;
    }

    public void setBillingPostalCode(final Object billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public Object getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setDandbCompanyId(final Object dandbCompanyId) {
        this.dandbCompanyId = dandbCompanyId;
    }

    public Object getDandbCompanyId() {
        return dandbCompanyId;
    }

    public void setPhotoUrl(final String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setMasterRecordId(final Object masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    public Object getMasterRecordId() {
        return masterRecordId;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setLastViewedDate(final String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setShippingGeocodeAccuracy(final Object shippingGeocodeAccuracy) {
        this.shippingGeocodeAccuracy = shippingGeocodeAccuracy;
    }

    public Object getShippingGeocodeAccuracy() {
        return shippingGeocodeAccuracy;
    }

    public void setDunsNumber(final Object dunsNumber) {
        this.dunsNumber = dunsNumber;
    }

    public Object getDunsNumber() {
        return dunsNumber;
    }

    public void setSic(final Object sic) {
        this.sic = sic;
    }

    public Object getSic() {
        return sic;
    }

    public void setShippingStreet(final Object shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public Object getShippingStreet() {
        return shippingStreet;
    }

    public void setCleanStatus(final String cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public String getCleanStatus() {
        return cleanStatus;
    }

    public void setShippingPostalCode(final Object shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public Object getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setYearStarted(final Object yearStarted) {
        this.yearStarted = yearStarted;
    }

    public Object getYearStarted() {
        return yearStarted;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCustomerPriorityC(final Object customerPriorityC) {
        this.customerPriorityC = customerPriorityC;
    }

    public Object getCustomerPriorityC() {
        return customerPriorityC;
    }

    public void setShippingState(final Object shippingState) {
        this.shippingState = shippingState;
    }

    public Object getShippingState() {
        return shippingState;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSicDesc(final Object sicDesc) {
        this.sicDesc = sicDesc;
    }

    public Object getSicDesc() {
        return sicDesc;
    }

    public void setBillingState(final Object billingState) {
        this.billingState = billingState;
    }

    public Object getBillingState() {
        return billingState;
    }

    public void setAnnualRevenue(final Object annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public Object getAnnualRevenue() {
        return annualRevenue;
    }

    public void setJigsaw(final Object jigsaw) {
        this.jigsaw = jigsaw;
    }

    public Object getJigsaw() {
        return jigsaw;
    }

    public void setActiveC(final Object activeC) {
        this.activeC = activeC;
    }

    public Object getActiveC() {
        return activeC;
    }

    public void setSite(final Object site) {
        this.site = site;
    }

    public Object getSite() {
        return site;
    }

    public void setOwnership(final Object ownership) {
        this.ownership = ownership;
    }

    public Object getOwnership() {
        return ownership;
    }

    public void setDescription(final Object description) {
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }

    public void setRating(final Object rating) {
        this.rating = rating;
    }

    public Object getRating() {
        return rating;
    }

    public void setWebsite(final Object website) {
        this.website = website;
    }

    public Object getWebsite() {
        return website;
    }

    public void setLastReferencedDate(final String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setBillingLatitude(final Object billingLatitude) {
        this.billingLatitude = billingLatitude;
    }

    public Object getBillingLatitude() {
        return billingLatitude;
    }

    public void setNumberOfEmployees(final Object numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Object getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setBillingAddress(final Object billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Object getBillingAddress() {
        return billingAddress;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setSLASerialNumberC(final Object sLASerialNumberC) {
        this.slaserialNumberC = sLASerialNumberC;
    }

    public Object getSLASerialNumberC() {
        return slaserialNumberC;
    }

    public void setBillingLongitude(final Object billingLongitude) {
        this.billingLongitude = billingLongitude;
    }

    public Object getBillingLongitude() {
        return billingLongitude;
    }

    public void setTradestyle(final Object tradestyle) {
        this.tradestyle = tradestyle;
    }

    public Object getTradestyle() {
        return tradestyle;
    }

    public void setPhone(final Object phone) {
        this.phone = phone;
    }

    public Object getPhone() {
        return phone;
    }

    public void setNumberofLocationsC(final Object numberofLocationsC) {
        this.numberofLocationsC = numberofLocationsC;
    }

    public Object getNumberofLocationsC() {
        return numberofLocationsC;
    }

    public void setUpsellOpportunityC(final Object upsellOpportunityC) {
        this.upsellOpportunityC = upsellOpportunityC;
    }

    public Object getUpsellOpportunityC() {
        return upsellOpportunityC;
    }

    public void setShippingCountry(final Object shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public Object getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCity(final Object shippingCity) {
        this.shippingCity = shippingCity;
    }

    public Object getShippingCity() {
        return shippingCity;
    }

    public void setParentId(final Object parentId) {
        this.parentId = parentId;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setNaicsDesc(final Object naicsDesc) {
        this.naicsDesc = naicsDesc;
    }

    public Object getNaicsDesc() {
        return naicsDesc;
    }

    public void setAccountNumber(final Object accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Object getAccountNumber() {
        return accountNumber;
    }

    public void setSystemModstamp(final String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setType(final Object type) {
        this.type = type;
    }

    public Object getType() {
        return type;
    }

    public void setBillingCountry(final Object billingCountry) {
        this.billingCountry = billingCountry;
    }

    public Object getBillingCountry() {
        return billingCountry;
    }

    public Object getSlaexpirationDateC() {
        return slaexpirationDateC;
    }

    public void setSlaexpirationDateC(final Object slaexpirationDateC) {
        this.slaexpirationDateC = slaexpirationDateC;
    }

    public void setBillingStreet(final Object billingStreet) {
        this.billingStreet = billingStreet;
    }

    public Object getBillingStreet() {
        return billingStreet;
    }

    public void setShippingAddress(final Object shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Object getShippingAddress() {
        return shippingAddress;
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

    public void setFax(final Object fax) {
        this.fax = fax;
    }

    public Object getFax() {
        return fax;
    }

    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setShippingLongitude(final Object shippingLongitude) {
        this.shippingLongitude = shippingLongitude;
    }

    public Object getShippingLongitude() {
        return shippingLongitude;
    }
}