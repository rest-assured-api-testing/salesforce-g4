package entities.Campaign;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class CampaignCreate {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> errors;

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setErrors(final List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getErrors() {
        return errors;
    }
}
