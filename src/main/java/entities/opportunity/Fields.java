package entities.opportunity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields{

	@JsonProperty("CloseDate")
	private CloseDate closeDate;

	public void setCloseDate(CloseDate closeDate){
		this.closeDate = closeDate;
	}

	public CloseDate getCloseDate(){
		return closeDate;
	}
}