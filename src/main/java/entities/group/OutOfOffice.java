package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class OutOfOffice{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
