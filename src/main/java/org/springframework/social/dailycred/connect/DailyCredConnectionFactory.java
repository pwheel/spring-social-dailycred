package org.springframework.social.dailycred.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.dailycred.api.DailyCred;

/**
 * DailyCred {@link OAuth2ConnectionFactory} implementation.
 *
 * @author paul.wheeler
 */
public class DailyCredConnectionFactory extends OAuth2ConnectionFactory<DailyCred> {

/**
 * Creates a DailyCredConnectionFactory for the given application ID and secret.
 * @param appId The application's App ID as assigned by Facebook
 * @param appSecret The application's App Secret as assigned by Facebook
 */
public DailyCredConnectionFactory(String appId, String appSecret) {
    super("dailycred", new DailyCredServiceProvider(appId, appSecret), new DailyCredAdapter());
}

}
