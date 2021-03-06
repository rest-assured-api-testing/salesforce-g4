/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package utilities;

import java.util.HashMap;

public class JsonFormat {

    /**
     * Converts two string to format json.
     * This method only work to request type patch.
     *
     * @param parameter to change.
     * @param value which parameter will have.
     * @return string in format json.
     */
    public static String jsonConvert(final String parameter, final String value) {
        return "{\"" + parameter + "\": \"" + value + "\"}";
    }
}
