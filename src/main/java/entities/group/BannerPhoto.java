package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BannerPhoto{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object bannerPhotoVersionId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String bannerPhotoUrl;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String url;

	public void setBannerPhotoVersionId(Object bannerPhotoVersionId){
		this.bannerPhotoVersionId = bannerPhotoVersionId;
	}

	public Object getBannerPhotoVersionId(){
		return bannerPhotoVersionId;
	}

	public void setBannerPhotoUrl(String bannerPhotoUrl){
		this.bannerPhotoUrl = bannerPhotoUrl;
	}

	public String getBannerPhotoUrl(){
		return bannerPhotoUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}
