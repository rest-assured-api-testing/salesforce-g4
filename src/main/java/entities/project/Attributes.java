package entities.project;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Attributes{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
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
