package org.springframework.social.dailycred.api.impl;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.dailycred.api.DailyCredProfile;
import org.springframework.social.dailycred.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Provides implementation of {@link UserOperations}. Only the basic method to get the user profile is supported at
 * present.
 *
 * @author paul.wheeler
 */
public class UserTemplate extends AbstractDailyCredOperations implements UserOperations {

    private final RestTemplate restTemplate;

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves the profile for the authenticated user.
     *
     * @return the user's profile information.
     * @throws org.springframework.social.ApiException
     *          if there is an error while communicating with DailyCred.
     * @throws org.springframework.social.MissingAuthorizationException
     *          if DailyCredTemplate was not created with an access token.
     */
    @Override
    public DailyCredProfile getUserProfile() throws ApiException, MissingAuthorizationException {
        requireAuthorization();
        return restTemplate.getForObject("https://www.dailycred.com/graph/me.json", DailyCredProfile.class);
    }
}
