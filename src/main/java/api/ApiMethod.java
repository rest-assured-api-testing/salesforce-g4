package api;

public enum ApiMethod {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    PUT("PUT"),
    PATCH("PATCH");

    private String name;

    ApiMethod(String name) {
        this.name = name;
    }

    public String toName() {
        return name;
    }
}
