package entities.contact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name{

	@JsonProperty("displayValue")
	private Object displayValue;

	@JsonProperty("value")
	private String value;

	public void setDisplayValue(Object displayValue){
		this.displayValue = displayValue;
	}

	public Object getDisplayValue(){
		return displayValue;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}