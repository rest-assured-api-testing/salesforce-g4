package entities.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields{

	@JsonProperty("Name")
	private Name name;

	public void setName(Name name){
		this.name = name;
	}

	public Name getName(){
		return name;
	}
}