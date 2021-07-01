/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */

package generalsetting;

public enum Header {
    SOBJECTS("sobjects"),
    AUTHORIZATION("Authorization"),
    BEARER("Bearer "),
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
