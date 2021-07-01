/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package salesforce.entities.product;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Product {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Attributes attributes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object displayUrl;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isDeleted;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object productCode;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isActive;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object externalId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastViewedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastReferencedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object stockKeepingUnit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object externalDataSourceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String systemModstamp;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isArchived;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdById;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object quantityUnitOfMeasure;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object family;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedById;

    public void setLastModifiedDate(final String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setDisplayUrl(final Object displayUrl) {
        this.displayUrl = displayUrl;
    }

    public Object getDisplayUrl() {
        return displayUrl;
    }

    public void setIsDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setDescription(final Object description) {
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }

    public void setProductCode(final Object productCode) {
        this.productCode = productCode;
    }

    public Object getProductCode() {
        return productCode;
    }

    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setExternalId(final Object externalId) {
        this.externalId = externalId;
    }

    public Object getExternalId() {
        return externalId;
    }

    public void setLastViewedDate(final String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastReferencedDate(final String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setStockKeepingUnit(final Object stockKeepingUnit) {
        this.stockKeepingUnit = stockKeepingUnit;
    }

    public Object getStockKeepingUnit() {
        return stockKeepingUnit;
    }

    public void setExternalDataSourceId(final Object externalDataSourceId) {
        this.externalDataSourceId = externalDataSourceId;
    }

    public Object getExternalDataSourceId() {
        return externalDataSourceId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSystemModstamp(final String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public boolean isIsArchived() {
        return isArchived;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setQuantityUnitOfMeasure(final Object quantityUnitOfMeasure) {
        this.quantityUnitOfMeasure = quantityUnitOfMeasure;
    }

    public Object getQuantityUnitOfMeasure() {
        return quantityUnitOfMeasure;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setFamily(final Object family) {
        this.family = family;
    }

    public Object getFamily() {
        return family;
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
}
