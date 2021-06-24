package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Motif{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mediumIconUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String color;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String largeIconUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String smallIconUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object svgIconUrl;

	public void setMediumIconUrl(String mediumIconUrl){
		this.mediumIconUrl = mediumIconUrl;
	}

	public String getMediumIconUrl(){
		return mediumIconUrl;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setLargeIconUrl(String largeIconUrl){
		this.largeIconUrl = largeIconUrl;
	}

	public String getLargeIconUrl(){
		return largeIconUrl;
	}

	public void setSmallIconUrl(String smallIconUrl){
		this.smallIconUrl = smallIconUrl;
	}

	public String getSmallIconUrl(){
		return smallIconUrl;
	}

	public void setSvgIconUrl(Object svgIconUrl){
		this.svgIconUrl = svgIconUrl;
	}

	public Object getSvgIconUrl(){
		return svgIconUrl;
	}
}
