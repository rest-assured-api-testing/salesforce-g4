package entities.contact;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact{
    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("MasterRecordId")
    public Object masterRecordId;
    @JsonProperty("AccountId")
    public Object accountId;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("FirstName")
    public Object firstName;
    @JsonProperty("Salutation")
    public Object salutation;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("OtherStreet")
    public Object otherStreet;
    @JsonProperty("OtherCity")
    public Object otherCity;
    @JsonProperty("OtherState")
    public Object otherState;
    @JsonProperty("OtherPostalCode")
    public Object otherPostalCode;
    @JsonProperty("OtherCountry")
    public Object otherCountry;
    @JsonProperty("OtherLatitude")
    public Object otherLatitude;
    @JsonProperty("OtherLongitude")
    public Object otherLongitude;
    @JsonProperty("OtherGeocodeAccuracy")
    public Object otherGeocodeAccuracy;
    @JsonProperty("OtherAddress")
    public Object otherAddress;
    @JsonProperty("MailingStreet")
    public Object mailingStreet;
    @JsonProperty("MailingCity")
    public Object mailingCity;
    @JsonProperty("MailingState")
    public Object mailingState;
    @JsonProperty("MailingPostalCode")
    public Object mailingPostalCode;
    @JsonProperty("MailingCountry")
    public Object mailingCountry;
    @JsonProperty("MailingLatitude")
    public Object mailingLatitude;
    @JsonProperty("MailingLongitude")
    public Object mailingLongitude;
    @JsonProperty("MailingGeocodeAccuracy")
    public Object mailingGeocodeAccuracy;
    @JsonProperty("MailingAddress")
    public Object mailingAddress;
    @JsonProperty("Phone")
    public Object phone;
    @JsonProperty("Fax")
    public Object fax;
    @JsonProperty("MobilePhone")
    public Object mobilePhone;
    @JsonProperty("HomePhone")
    public Object homePhone;
    @JsonProperty("OtherPhone")
    public Object otherPhone;
    @JsonProperty("AssistantPhone")
    public Object assistantPhone;
    @JsonProperty("ReportsToId")
    public Object reportsToId;
    @JsonProperty("Email")
    public Object email;
    @JsonProperty("Title")
    public Object title;
    @JsonProperty("Department")
    public Object department;
    @JsonProperty("AssistantName")
    public Object assistantName;
    @JsonProperty("LeadSource")
    public Object leadSource;
    @JsonProperty("Birthdate")
    public Object birthdate;
    @JsonProperty("Description")
    public Object description;
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
    @JsonProperty("LastCURequestDate")
    public Object lastCURequestDate;
    @JsonProperty("LastCUUpdateDate")
    public Object lastCUUpdateDate;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("EmailBouncedReason")
    public Object emailBouncedReason;
    @JsonProperty("EmailBouncedDate")
    public Object emailBouncedDate;
    @JsonProperty("IsEmailBounced")
    public Boolean isEmailBounced;
    @JsonProperty("PhotoUrl")
    public String photoUrl;
    @JsonProperty("Jigsaw")
    public Object jigsaw;
    @JsonProperty("JigsawContactId")
    public Object jigsawContactId;
    @JsonProperty("CleanStatus")
    public String cleanStatus;
    @JsonProperty("IndividualId")
    public Object individualId;
    @JsonProperty("Level__c")
    public Object level__c;
    @JsonProperty("Languages__c")
    public Object languages__c;

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

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Object getMasterRecordId() {
        return masterRecordId;
    }

    public void setMasterRecordId(Object masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    public Object getSalutation() {
        return salutation;
    }

    public void setSalutation(Object salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOtherStreet() {
        return otherStreet;
    }

    public void setOtherStreet(Object otherStreet) {
        this.otherStreet = otherStreet;
    }

    public Object getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(Object otherCity) {
        this.otherCity = otherCity;
    }

    public Object getOtherState() {
        return otherState;
    }

    public void setOtherState(Object otherState) {
        this.otherState = otherState;
    }

    public Object getOtherPostalCode() {
        return otherPostalCode;
    }

    public void setOtherPostalCode(Object otherPostalCode) {
        this.otherPostalCode = otherPostalCode;
    }

    public Object getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(Object otherCountry) {
        this.otherCountry = otherCountry;
    }

    public Object getOtherLatitude() {
        return otherLatitude;
    }

    public void setOtherLatitude(Object otherLatitude) {
        this.otherLatitude = otherLatitude;
    }

    public Object getOtherLongitude() {
        return otherLongitude;
    }

    public void setOtherLongitude(Object otherLongitude) {
        this.otherLongitude = otherLongitude;
    }

    public Object getOtherGeocodeAccuracy() {
        return otherGeocodeAccuracy;
    }

    public void setOtherGeocodeAccuracy(Object otherGeocodeAccuracy) {
        this.otherGeocodeAccuracy = otherGeocodeAccuracy;
    }

    public Object getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(Object otherAddress) {
        this.otherAddress = otherAddress;
    }
}
