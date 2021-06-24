package entities.product;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ProductCreate {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public boolean getSuccess() {
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
}
