package entities.opportunity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Opportunity{

	@JsonProperty("weakEtag")
	private long weakEtag;

	@JsonProperty("apiName")
	private String apiName;

	@JsonProperty("childRelationships")
	private ChildRelationships childRelationships;

	@JsonProperty("recordTypeId")
	private String recordTypeId;

	@JsonProperty("lastModifiedDate")
	private String lastModifiedDate;

	@JsonProperty("lastModifiedById")
	private String lastModifiedById;

	@JsonProperty("systemModstamp")
	private String systemModstamp;

	@JsonProperty("eTag")
	private String eTag;

	@JsonProperty("id")
	private String id;

	@JsonProperty("fields")
	private Fields fields;

	@JsonProperty("recordTypeInfo")
	private Object recordTypeInfo;

	public void setWeakEtag(long weakEtag){
		this.weakEtag = weakEtag;
	}

	public long getWeakEtag(){
		return weakEtag;
	}

	public void setApiName(String apiName){
		this.apiName = apiName;
	}

	public String getApiName(){
		return apiName;
	}

	public void setChildRelationships(ChildRelationships childRelationships){
		this.childRelationships = childRelationships;
	}

	public ChildRelationships getChildRelationships(){
		return childRelationships;
	}

	public void setRecordTypeId(String recordTypeId){
		this.recordTypeId = recordTypeId;
	}

	public String getRecordTypeId(){
		return recordTypeId;
	}

	public void setLastModifiedDate(String lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedDate(){
		return lastModifiedDate;
	}

	public void setLastModifiedById(String lastModifiedById){
		this.lastModifiedById = lastModifiedById;
	}

	public String getLastModifiedById(){
		return lastModifiedById;
	}

	public void setSystemModstamp(String systemModstamp){
		this.systemModstamp = systemModstamp;
	}

	public String getSystemModstamp(){
		return systemModstamp;
	}

	public void setETag(String eTag){
		this.eTag = eTag;
	}

	public String getETag(){
		return eTag;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFields(Fields fields){
		this.fields = fields;
	}

	public Fields getFields(){
		return fields;
	}

	public void setRecordTypeInfo(Object recordTypeInfo){
		this.recordTypeInfo = recordTypeInfo;
	}

	public Object getRecordTypeInfo(){
		return recordTypeInfo;
	}
}