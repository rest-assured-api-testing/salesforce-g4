package entities.account;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResponse{
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("success")
	private boolean success;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("id")
	private String id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("errors")
	private List<Object> errors;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Object> getErrors() {
		return errors;
	}

	public void setErrors(List<Object> errors) {
		this.errors = errors;
	}
}