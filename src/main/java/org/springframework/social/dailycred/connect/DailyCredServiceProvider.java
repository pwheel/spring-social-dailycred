package org.springframework.social.dailycred.connect;

import org.springframework.social.dailycred.api.DailyCred;
import org.springframework.social.dailycred.api.impl.DailyCredTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * DailyCred Service Provider implementation.
 *
 * @author paul.wheeler
 */
public class DailyCredServiceProvider extends AbstractOAuth2ServiceProvider<DailyCred> {

    private static final String DAILYCRED_AUTHORISATION_URL = "https://www.dailycred.com/connect";
    private static final String DAILYCRED_ACCESS_TOKEN_URL = "https://www.dailycred.com/oauth/access_token";

    /**
     * Creates a DailyCredServiceProvider for the given application ID, and secret.
     * @param appId The application's App ID as assigned by Facebook
     * @param appSecret The application's App Secret as assigned by Facebook
     */
    public DailyCredServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, DAILYCRED_AUTHORISATION_URL, DAILYCRED_ACCESS_TOKEN_URL));
    }

    public DailyCred getApi(String accessToken) {
        return new DailyCredTemplate(accessToken);
    }

}
