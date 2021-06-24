package entities.product;

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

	public void setLastModifiedDate(String lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedDate(){
		return lastModifiedDate;
	}

	public void setDisplayUrl(Object displayUrl){
		this.displayUrl = displayUrl;
	}

	public Object getDisplayUrl(){
		return displayUrl;
	}

	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}

	public boolean isIsDeleted(){
		return isDeleted;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setProductCode(Object productCode){
		this.productCode = productCode;
	}

	public Object getProductCode(){
		return productCode;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setExternalId(Object externalId){
		this.externalId = externalId;
	}

	public Object getExternalId(){
		return externalId;
	}

	public void setLastViewedDate(String lastViewedDate){
		this.lastViewedDate = lastViewedDate;
	}

	public String getLastViewedDate(){
		return lastViewedDate;
	}

	public void setLastReferencedDate(String lastReferencedDate){
		this.lastReferencedDate = lastReferencedDate;
	}

	public String getLastReferencedDate(){
		return lastReferencedDate;
	}

	public void setStockKeepingUnit(Object stockKeepingUnit){
		this.stockKeepingUnit = stockKeepingUnit;
	}

	public Object getStockKeepingUnit(){
		return stockKeepingUnit;
	}

	public void setExternalDataSourceId(Object externalDataSourceId){
		this.externalDataSourceId = externalDataSourceId;
	}

	public Object getExternalDataSourceId(){
		return externalDataSourceId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSystemModstamp(String systemModstamp){
		this.systemModstamp = systemModstamp;
	}

	public String getSystemModstamp(){
		return systemModstamp;
	}

	public void setIsArchived(boolean isArchived){
		this.isArchived = isArchived;
	}

	public boolean isIsArchived(){
		return isArchived;
	}

	public void setCreatedById(String createdById){
		this.createdById = createdById;
	}

	public String getCreatedById(){
		return createdById;
	}

	public void setQuantityUnitOfMeasure(Object quantityUnitOfMeasure){
		this.quantityUnitOfMeasure = quantityUnitOfMeasure;
	}

	public Object getQuantityUnitOfMeasure(){
		return quantityUnitOfMeasure;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setFamily(Object family){
		this.family = family;
	}

	public Object getFamily(){
		return family;
	}

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLastModifiedById(String lastModifiedById){
		this.lastModifiedById = lastModifiedById;
	}

	public String getLastModifiedById(){
		return lastModifiedById;
	}
}
