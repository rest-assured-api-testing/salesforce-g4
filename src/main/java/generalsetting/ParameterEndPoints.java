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

package generalsetting;

import static generalsetting.GetEnv.dotenv;

public class ParameterEndPoints {
    public static final String URL_TOKEN = dotenv.get("URL_TOKEN");
    public static final String URL_BASE =  dotenv.get("URL_BASE");
    public static final String PRODUCT_ID =  dotenv.get("PRODUCT_ID");
    public static final String GROUP_ID =  dotenv.get("GROUP_ID");
    public static final String PRODUCT =  dotenv.get("PRODUCT");
    public static final String PRODUCT_TO_INTERACT =  dotenv.get("PRODUCT_TO_INTERACT");
    public static final String GROUP =  dotenv.get("GROUP");
    public static final String GROUP_TO_INTERACT =  dotenv.get("GROUP_TO_INTERACT");
    public static final String URL_BASEO =  dotenv.get("URL_BASEO");
    public static final String ACCOUNT =  dotenv.get("ACCOUNT");
    public static final String CONTACT =  dotenv.get("CONTACT");
    public static final String OPPORTUNITY =  dotenv.get("OPPORTUNITY");
}
