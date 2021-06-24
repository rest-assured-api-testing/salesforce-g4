/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Photo{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fullEmailPhotoUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object photoVersionId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String largePhotoUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String smallPhotoUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mediumPhotoUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String standardEmailPhotoUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String url;

	public void setFullEmailPhotoUrl(String fullEmailPhotoUrl){
		this.fullEmailPhotoUrl = fullEmailPhotoUrl;
	}

	public String getFullEmailPhotoUrl(){
		return fullEmailPhotoUrl;
	}

	public void setPhotoVersionId(Object photoVersionId){
		this.photoVersionId = photoVersionId;
	}

	public Object getPhotoVersionId(){
		return photoVersionId;
	}

	public void setLargePhotoUrl(String largePhotoUrl){
		this.largePhotoUrl = largePhotoUrl;
	}

	public String getLargePhotoUrl(){
		return largePhotoUrl;
	}

	public void setSmallPhotoUrl(String smallPhotoUrl){
		this.smallPhotoUrl = smallPhotoUrl;
	}

	public String getSmallPhotoUrl(){
		return smallPhotoUrl;
	}

	public void setMediumPhotoUrl(String mediumPhotoUrl){
		this.mediumPhotoUrl = mediumPhotoUrl;
	}

	public String getMediumPhotoUrl(){
		return mediumPhotoUrl;
	}

	public void setStandardEmailPhotoUrl(String standardEmailPhotoUrl){
		this.standardEmailPhotoUrl = standardEmailPhotoUrl;
	}

	public String getStandardEmailPhotoUrl(){
		return standardEmailPhotoUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}
