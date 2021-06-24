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

public class ParameterUser {
    public static final String GRANT_TYPE_KEY = dotenv.get("GRANT_TYPE_KEY");
    public static final String GRANT_TYPE_VALUE = dotenv.get("GRANT_TYPE_VALUE");
    public static final String CLIENT_ID_KEY = dotenv.get("CLIENT_ID_KEY");
    public static final String CLIENT_ID_VALUE = dotenv.get("CLIENT_ID_VALUE");
    public static final String CLIENT_SECRET_KEY = dotenv.get("CLIENT_SECRET_KEY");
    public static final String CLIENT_SECRET_VALUE = dotenv.get("CLIENT_SECRET_VALUE");
    public static final String USERNAME_KEY = dotenv.get("USERNAME_KEY");
    public static final String USERNAME_VALUE = dotenv.get("USERNAME_VALUE");
    public static final String PASSWORD_KEY = dotenv.get("PASSWORD_KEY");
    public static final String PASSWORD_VALUE = dotenv.get("PASSWORD_VALUE");
    public static final String TOKEN_SECURITY = dotenv.get("TOKEN_SECURITY");
}
