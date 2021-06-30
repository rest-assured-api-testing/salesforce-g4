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

public enum EndPoint {
    TOKEN("https://login.salesforce.com/services/oauth2/token","",""),
    URL_BASE(dotenv.get("URL_BASE"),  "",""),
    PRODUCT("sobjects/Product2/",  "sobjects/Product2/{productId}","productId"),
    GROUP("chatter/groups",       "chatter/groups/{groupId}",   "groupId"),
    ACCOUNT("sobjects/Account",  "sobjects/Account/{accountId}","accountId"),
    CONTACT("sobjects/Contact",  "sobjects/Contact/{contactId}","contactId"),
    OPPORTUNITY("sobjects/Opportunity",  "sobjects/Opportunity/{opportunityId}","opportunityId"),
    CAMPAIGN("/sobjects/Campaign/",  "sobjects/Campaign/{campaignId}","campaignId"),
    INDIVIDUAL("sobjects/Individual",  "sobjects/Individual/{individualId}","individualId");

    private final String endPoint;
    private final String id;
    private final String endPointInteract;

    private EndPoint(String endPoint, String endPointInteract, String id) {
        this.endPoint = endPoint;
        this.id = id;
        this.endPointInteract = endPointInteract;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String toSetId() {
        return id;
    }

    public String getEndPointInteract() {
        return endPointInteract;
    }
}
