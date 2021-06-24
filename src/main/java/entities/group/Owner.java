package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Owner{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean isInThisCommunity;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String displayName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String companyName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Photo photo;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object reputation;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean isActive;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object title;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object additionalLabel;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String url;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private OutOfOffice outOfOffice;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String communityNickname;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object mySubscription;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Motif motif;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userType;

	public void setIsInThisCommunity(boolean isInThisCommunity){
		this.isInThisCommunity = isInThisCommunity;
	}

	public boolean isIsInThisCommunity(){
		return isInThisCommunity;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setPhoto(Photo photo){
		this.photo = photo;
	}

	public Photo getPhoto(){
		return photo;
	}

	public void setReputation(Object reputation){
		this.reputation = reputation;
	}

	public Object getReputation(){
		return reputation;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setTitle(Object title){
		this.title = title;
	}

	public Object getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setAdditionalLabel(Object additionalLabel){
		this.additionalLabel = additionalLabel;
	}

	public Object getAdditionalLabel(){
		return additionalLabel;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setOutOfOffice(OutOfOffice outOfOffice){
		this.outOfOffice = outOfOffice;
	}

	public OutOfOffice getOutOfOffice(){
		return outOfOffice;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setCommunityNickname(String communityNickname){
		this.communityNickname = communityNickname;
	}

	public String getCommunityNickname(){
		return communityNickname;
	}

	public void setMySubscription(Object mySubscription){
		this.mySubscription = mySubscription;
	}

	public Object getMySubscription(){
		return mySubscription;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMotif(Motif motif){
		this.motif = motif;
	}

	public Motif getMotif(){
		return motif;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}
}
