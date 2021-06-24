package entities.group;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Information{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object text;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object title;

	public void setText(Object text){
		this.text = text;
	}

	public Object getText(){
		return text;
	}

	public void setTitle(Object title){
		this.title = title;
	}

	public Object getTitle(){
		return title;
	}
}
