package generalsetting;

import static generalsetting.GetEnv.dotenv;

public enum Param {
    GRANT_TYPE("grant_type", "password"),
    CLIENT_ID("client_id", dotenv.get("CLIENT_ID_VALUE")),
    CLIENT_SECRET("client_secret", dotenv.get("CLIENT_SECRET_VALUE")),
    USERNAME("username", dotenv.get("USERNAME_VALUE")),
    PASSWORD("password", dotenv.get("PASSWORD_VALUE") + dotenv.get("TOKEN_SECURITY"));

    private String key;
    private String value;

    private Param(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
