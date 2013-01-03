package org.springframework.social.dailycred.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.dailycred.api.DailyCred;
import org.springframework.social.dailycred.api.DailyCredProfile;

/**
 * DailyCred {@link ApiAdapter} implementation. Adapts generic behaviour to DailyCred implementation.
 *
 * @author paul.wheeler
 */
public class DailyCredAdapter implements ApiAdapter<DailyCred> {

    public boolean test(DailyCred dailyCred) {
        try {
            dailyCred.userOperations().getUserProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    public void setConnectionValues(DailyCred dailyCred, ConnectionValues values) {
        DailyCredProfile profile = dailyCred.userOperations().getUserProfile();
        values.setProviderUserId(profile.getId());
        values.setDisplayName(profile.getUsername());
        //values.setProfileUrl("http://dailyCred.com/profile.php?id=" + profile.getId());
        //values.setImageUrl("http://graph.dailyCred.com/" + profile.getId() + "/picture");
    }

    public UserProfile fetchUserProfile(DailyCred dailyCred) {
        DailyCredProfile profile = dailyCred.userOperations().getUserProfile();
        return new UserProfileBuilder().setName(profile.getDisplay()).
                setEmail(profile.getEmail()).setUsername(profile.getUsername()).build();
    }

    /**
     * Not implemented, does not apply.
     * @param dailyCred
     * @param message
     */
    public void updateStatus(DailyCred dailyCred, String message) {

    }
}
