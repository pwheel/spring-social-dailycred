package org.springframework.social.dailycred.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;

/**
 * Interface describing the set of operations that can be performed on a user in DailyCred.
 *
 * @author paul.wheeler
 */
public interface UserOperations {

    /**
     * Retrieves the profile for the authenticated user.
     * @return the user's profile information.
     * @throws ApiException if there is an error while communicating with DailyCred.
     * @throws MissingAuthorizationException if DailyCredTemplate was not created with an access token.
     */
    DailyCredProfile getUserProfile() throws ApiException, MissingAuthorizationException;
}
