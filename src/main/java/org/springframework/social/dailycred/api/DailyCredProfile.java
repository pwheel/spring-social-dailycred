package org.springframework.social.dailycred.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Model class containing a DailyCred user's 'profile' information. This relates to the result of the call to
 * https://www.dailycred.com/graph/me.json. See https://www.dailycred.com/docs/serverside for more details.
 *
 * Not all the content of the response is currently bound to the POJO.
 *
 * @author paul.wheeler
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyCredProfile implements Serializable {
    @JsonProperty("is_email_verified")
    private boolean isEmailVerified;
    @JsonProperty("access_tokens")
    private Map<String, String> accessTokens;
    @JsonProperty("updated_at")
    private Long updatedAt;
    private String id;
    private String display;
    private boolean guest;
    private String username;
    private Long created;
    private String email;

    /**
     * Returns true if the email address has been verified.
     * @return true if the email has been verified.
     */
    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.isEmailVerified = emailVerified;
    }

    /**
     * Returns the access tokens associated with this user's account in DailyCred. For example, the {@link Map} could
     * contain Facebook, Twitter, or Google credentials. The key is the name of the provider, e.g. dailycred, google.
     * @return
     */
    public Map<String, String> getAccessTokens() {
        return accessTokens;
    }

    public void setAccessTokens(Map<String, String> accessTokens) {
        this.accessTokens = accessTokens;
    }

    /**
     * Returns the last time the account was updated.
     * @return
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * The id of the user in DailyCred.
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The display name of the user.
     * @return
     */
    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * Returns true if the user is a guest.
     * @return
     */
    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    /**
     * The username of the user.
     * @return
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * The time the user account was created.
     * @return
     */
    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * The email address of the user
     * @return
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DailyCredProfile(boolean emailverified, Map<String, String> accessTokens, Long updatedAt, String id,
                            String display, boolean guest, String username, Long created, String email) {

        isEmailVerified = emailverified;
        this.accessTokens = accessTokens;
        this.updatedAt = updatedAt;
        this.id = id;
        this.display = display;
        this.guest = guest;
        this.username = username;
        this.created = created;
        this.email = email;
    }

    /**
     * Default constructor. Needed to allow JSON mappings to be performed by Jackson.
     */
    public DailyCredProfile() {

    }
}
