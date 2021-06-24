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

package entities.contact;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    private Attributes attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("MasterRecordId")
    private Object masterRecordId;
    @JsonProperty("AccountId")
    private Object accountId;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("FirstName")
    private Object firstName;
    @JsonProperty("Salutation")
    private Object salutation;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("OtherStreet")
    private Object otherStreet;
    @JsonProperty("OtherCity")
    private Object otherCity;
    @JsonProperty("OtherState")
    private Object otherState;
    @JsonProperty("OtherPostalCode")
    private Object otherPostalCode;
    @JsonProperty("OtherCountry")
    private Object otherCountry;
    @JsonProperty("OtherLatitude")
    private Object otherLatitude;
    @JsonProperty("OtherLongitude")
    private Object otherLongitude;
    @JsonProperty("OtherGeocodeAccuracy")
    private Object otherGeocodeAccuracy;
    @JsonProperty("OtherAddress")
    private Object otherAddress;
    @JsonProperty("MailingStreet")
    private Object mailingStreet;
    @JsonProperty("MailingCity")
    private Object mailingCity;
    @JsonProperty("MailingState")
    private Object mailingState;
    @JsonProperty("MailingPostalCode")
    private Object mailingPostalCode;
    @JsonProperty("MailingCountry")
    private Object mailingCountry;
    @JsonProperty("MailingLatitude")
    private Object mailingLatitude;
    @JsonProperty("MailingLongitude")
    private Object mailingLongitude;
    @JsonProperty("MailingGeocodeAccuracy")
    private Object mailingGeocodeAccuracy;
    @JsonProperty("MailingAddress")
    private Object mailingAddress;
    @JsonProperty("Phone")
    private Object phone;
    @JsonProperty("Fax")
    private Object fax;
    @JsonProperty("MobilePhone")
    private Object mobilePhone;
    @JsonProperty("HomePhone")
    private Object homePhone;
    @JsonProperty("OtherPhone")
    private Object otherPhone;
    @JsonProperty("AssistantPhone")
    private Object assistantPhone;
    @JsonProperty("ReportsToId")
    private Object reportsToId;
    @JsonProperty("Email")
    private Object email;
    @JsonProperty("Title")
    private Object title;
    @JsonProperty("Department")
    private Object department;
    @JsonProperty("AssistantName")
    private Object assistantName;
    @JsonProperty("LeadSource")
    private Object leadSource;
    @JsonProperty("Birthdate")
    private Object birthdate;
    @JsonProperty("Description")
    private Object description;
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
    @JsonProperty("LastCURequestDate")
    private Object lastCURequestDate;
    @JsonProperty("LastCUUpdateDate")
    private Object lastCUUpdateDate;
    @JsonProperty("LastViewedDate")
    private Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    private Date lastReferencedDate;
    @JsonProperty("EmailBouncedReason")
    private Object emailBouncedReason;
    @JsonProperty("EmailBouncedDate")
    private Object emailBouncedDate;
    @JsonProperty("IsEmailBounced")
    private Boolean isEmailBounced;
    @JsonProperty("PhotoUrl")
    private String photoUrl;
    @JsonProperty("Jigsaw")
    private Object jigsaw;
    @JsonProperty("JigsawContactId")
    private Object jigsawContactId;
    @JsonProperty("CleanStatus")
    private String cleanStatus;
    @JsonProperty("IndividualId")
    private Object individualId;
    @JsonProperty("Level__c")
    private Object level__c;
    @JsonProperty("Languages__c")
    private Object languages__c;


    public Contact() {
    }

    public Contact(final String lastName) {
        this.lastName = lastName;
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

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted) {
        isDeleted = deleted;
    }

    public Object getMasterRecordId() {
        return masterRecordId;
    }

    public void setMasterRecordId(final Object masterRecordId) {
        this.masterRecordId = masterRecordId;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(final Object accountId) {
        this.accountId = accountId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(final Object firstName) {
        this.firstName = firstName;
    }

    public Object getSalutation() {
        return salutation;
    }

    public void setSalutation(final Object salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Object getOtherStreet() {
        return otherStreet;
    }

    public void setOtherStreet(final Object otherStreet) {
        this.otherStreet = otherStreet;
    }

    public Object getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(final Object otherCity) {
        this.otherCity = otherCity;
    }

    public Object getOtherState() {
        return otherState;
    }

    public void setOtherState(final Object otherState) {
        this.otherState = otherState;
    }

    public Object getOtherPostalCode() {
        return otherPostalCode;
    }

    public void setOtherPostalCode(final Object otherPostalCode) {
        this.otherPostalCode = otherPostalCode;
    }

    public Object getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(final Object otherCountry) {
        this.otherCountry = otherCountry;
    }

    public Object getOtherLatitude() {
        return otherLatitude;
    }

    public void setOtherLatitude(final Object otherLatitude) {
        this.otherLatitude = otherLatitude;
    }

    public Object getOtherLongitude() {
        return otherLongitude;
    }

    public void setOtherLongitude(final Object otherLongitude) {
        this.otherLongitude = otherLongitude;
    }

    public Object getOtherGeocodeAccuracy() {
        return otherGeocodeAccuracy;
    }

    public void setOtherGeocodeAccuracy(final Object otherGeocodeAccuracy) {
        this.otherGeocodeAccuracy = otherGeocodeAccuracy;
    }

    public Object getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(final Object otherAddress) {
        this.otherAddress = otherAddress;
    }
}
