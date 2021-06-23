package entities.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("type")
	private String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("url")
	private String url;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}