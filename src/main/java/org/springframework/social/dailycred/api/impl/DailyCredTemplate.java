package org.springframework.social.dailycred.api.impl;

import org.springframework.social.dailycred.api.DailyCred;
import org.springframework.social.dailycred.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

/**
 * This is the central class for interacting with DailyCred. Only the bare minimum of functionality is currently
 * implemented.
 *
 * @author paul.wheeler
 */
public class DailyCredTemplate extends AbstractOAuth2ApiBinding implements DailyCred {

    private UserOperations userOperations;

    /**
     * Create a new instance of DailyCredTemplate.
     * This constructor creates the DailyCredTemplate using a given access token.
     * @param accessToken An access token given by DailyCrud after a successful OAuth 2 authentication.
     */
    public DailyCredTemplate(String accessToken) {
        super(accessToken);
        initialize();
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    // private helpers
    private void initialize() {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
        // TODO: Is this necessary?
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    private void initSubApis() {
        userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
    }
}
