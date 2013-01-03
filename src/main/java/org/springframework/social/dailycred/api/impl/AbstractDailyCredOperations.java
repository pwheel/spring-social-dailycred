package org.springframework.social.dailycred.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * Provides utility methods for checking if the user is authorized. Taken from the Facebook implementation.
 *
 * @author paul.wheeler
 */
class AbstractDailyCredOperations {

    private final boolean isAuthorized;

    public AbstractDailyCredOperations(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException();
        }
    }
}
