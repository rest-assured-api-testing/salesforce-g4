package generalsetting;

public enum Header {
    SOBJECTS("sobjects"),
    AUTHORIZATION("Authorization"),
    BEARER("Bearer"),
    ACCEPT("Accept"),
    APPLICATION_JSON("application/json"),
    CONTENT_TYPE("Content-Type"),
    X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded");

    private String value;

    Header(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
