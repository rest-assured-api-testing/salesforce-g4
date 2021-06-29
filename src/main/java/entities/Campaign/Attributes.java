package entities.Campaign;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Attributes {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;

    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
