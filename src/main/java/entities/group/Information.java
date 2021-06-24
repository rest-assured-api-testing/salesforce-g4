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
