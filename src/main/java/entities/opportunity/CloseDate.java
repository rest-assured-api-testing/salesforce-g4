package entities.opportunity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseDate{

	@JsonProperty("displayValue")
	private String displayValue;

	@JsonProperty("value")
	private String value;

	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}

	public String getDisplayValue(){
		return displayValue;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}