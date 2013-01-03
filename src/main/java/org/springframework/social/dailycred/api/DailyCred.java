package org.springframework.social.dailycred.api;

/**
 * Interface specifying a set of operations for interfacing with DailyCred. Note that DailyCred is not
 * a social webapp like Facebook or Twitter; the Spring Social support is merely a convenient method of performing
 * the OAuth 2 implementation.
 *
 * @author paul.wheeler
 */
public interface DailyCred {

    /**
     * Return the API for interacting with user operations.
     * @return API.
     */
    public UserOperations userOperations();
}
